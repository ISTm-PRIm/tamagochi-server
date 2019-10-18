package com.tamogochi.server.service.impl;

import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.entity.User;
import com.tamogochi.server.exception.EntityNotFoundException;
import com.tamogochi.server.exception.IncorrectRequestException;
import com.tamogochi.server.exception.Message;
import com.tamogochi.server.repository.PetRepository;
import com.tamogochi.server.repository.UserRepository_old;
import com.tamogochi.server.service.api.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserRepository_old userRepository;
    private final int INDICATOR_MAX_VALUE = 100;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, UserRepository_old userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Pet create(String userId, String name) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new EntityNotFoundException(Message.USER_NOT_FOUND);
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
