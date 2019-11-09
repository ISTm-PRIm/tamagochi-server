package com.tamogochi.server.service.api;

import com.tamogochi.server.entity.ActionType;
import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.entity.UpdateHistory;
import com.tamogochi.server.security.UserPrincipal;

import java.util.List;

public interface PetService {
    void changeIndicator(List<UpdateHistory> historList);
    Pet create(Long userId, String name);
    Pet die(String petId);
    Pet get(String petId);
    Pet get(UserPrincipal userPrincipal);
    Pet applyAction(ActionType action, UserPrincipal userPrincipal);
}
