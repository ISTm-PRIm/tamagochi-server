package com.tamogochi.server.service.api;

import com.tamogochi.server.entity.Pet;
import org.springframework.data.domain.Page;

public interface PetService {
    Pet create(String userId, String name);
    Page<Pet> findAllByLastDay();
}
