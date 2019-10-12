package com.tamogochi.server.service.api;

import com.tamogochi.server.entity.Pet;

public interface PetService {
    Pet create(String userId, String name);
}
