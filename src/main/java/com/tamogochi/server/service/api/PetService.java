package com.tamogochi.server.service.api;

import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.entity.UpdateHistory;

import java.util.List;

public interface PetService {
    Pet create(Long userId, String name);
    void changeIndicator(List<UpdateHistory> historList);
}
