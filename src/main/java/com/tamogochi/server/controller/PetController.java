package com.tamogochi.server.controller;

import com.tamogochi.server.dto.request.PetCreateRequest;
import com.tamogochi.server.dto.request.PetDeleteRequest;
import com.tamogochi.server.dto.request.PetPostRequest;
import com.tamogochi.server.dto.response.PetCreateResponse;
import com.tamogochi.server.dto.response.PetDeleteResponse;
import com.tamogochi.server.dto.response.PetPostResponse;
import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.entity.User;
import com.tamogochi.server.exception.ResourceNotFoundException;
import com.tamogochi.server.mapper.PetMapper;
import com.tamogochi.server.repository.UserRepository;
import com.tamogochi.server.security.CurrentUser;
import com.tamogochi.server.security.UserPrincipal;
import com.tamogochi.server.service.api.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private final PetMapper petMapper;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PetCreateResponse create(@Valid @RequestBody PetCreateRequest request, @CurrentUser UserPrincipal userPrincipal) {
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Pet pet = petService.create(user.getId(), request.getName());
        return new PetCreateResponse(petMapper.toDto(pet));
    }

    @PostMapping(value = "/die")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PetDeleteResponse delete(@Valid @RequestBody PetDeleteRequest request) {
        Pet pet = petService.die(request.getPetId());
        return new PetDeleteResponse(petMapper.toDto(pet));
    }

    @PostMapping(value = "/")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PetPostResponse get(@Valid @RequestBody PetPostRequest request) {
        Pet pet = petService.get(request.getPetId());
        return new PetPostResponse(petMapper.toDto(pet));
    }
}
