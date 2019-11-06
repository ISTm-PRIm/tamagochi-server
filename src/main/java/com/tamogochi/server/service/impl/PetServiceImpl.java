package com.tamogochi.server.service.impl;

import com.tamogochi.server.entity.*;
import com.tamogochi.server.exception.EntityNotFoundException;
import com.tamogochi.server.exception.IncorrectRequestException;
import com.tamogochi.server.exception.Message;
import com.tamogochi.server.repository.PetRepository;
import com.tamogochi.server.repository.UserRepository;
import com.tamogochi.server.service.Constant;
import com.tamogochi.server.service.api.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.tamogochi.server.service.Constant.INDICATOR_MAX_VALUE;

@Service("petService")
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Pet create(Long userId, String name) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new EntityNotFoundException(Message.USER_NOT_FOUND);
        } else {
            user.setPet(null);
            userRepository.save(user);
        }
        Pet oldPet = user.getPet();
        if (oldPet != null) {
            if (oldPet.getIsAlive()) {
                throw new IncorrectRequestException(Message.PET_ALREADY_EXISTS);
            } else {
                petRepository.delete(oldPet);
            }
        }

        Pet pet = create(name);
        user.setPet(pet);
        userRepository.save(user);
        return pet;
    }

    @Override
    public Pet die(String petId) {
        Pet pet = get(petId);
        pet.setFoolIndicator(Constant.INDICATOR_MIN_VALUE);
        pet.setHealthIndicator(Constant.INDICATOR_MIN_VALUE);
        pet.setIsAlive(false);

        return petRepository.save(pet);
    }

    @Override
    public Pet get(String petId) {
        Pet pet = petRepository.getPetById(petId);
        if (pet == null) {
            throw new EntityNotFoundException(Message.PET_NOT_FOUND);
        }
        return pet;
    }

    private Pet decrementIndicator(Pet pet, Indicator indicator, int decValue) {
        if (pet == null) return pet; //todo нужна обработка ошибок или забьем по классике?
        switch (indicator) {
            case FOOD_INDICATOR:
                pet.decrementFoodIndicator(decValue);
                break;
            case CLEAN_INDICATOR:
                pet.decrementCleanIndicator(decValue);
                break;
            case HEALTH_INDICATOR:
                pet.decrementHealthIndicator(decValue);
                break;
            case SLEEP_INDICATOR:
                pet.decrementSleepIndicator(decValue);
                break;
        }
        return pet;
    }

    @Override
    public void changeIndicator(List<UpdateHistory> historyList) {
        List<Pet> pets = petRepository.findAll();
        for (Pet pet : pets) {
            for (UpdateHistory history : historyList) {
                Indicator indicator = history.getIndicator();
                decrementIndicator(pet, indicator, history.getDecrementValue());
            }
            pet = petRepository.save(pet);
        }
    }


    private Pet create(String name) {
        Pet pet = new Pet();
        pet.setId(UUID.randomUUID().toString());
        pet.setName(name);
        pet.setCreateDate(new Date());
        pet.setCleanIndicator(INDICATOR_MAX_VALUE);
        pet.setFoolIndicator(INDICATOR_MAX_VALUE);
        pet.setHealthIndicator(INDICATOR_MAX_VALUE);
        pet.setSleepIndicator(INDICATOR_MAX_VALUE);
        pet.setIsAlive(true);
        return petRepository.save(pet);
    }

}
