package com.tamogochi.server.controller;

import com.tamogochi.server.dto.request.PetCreateRequest;
import com.tamogochi.server.dto.request.PetDeleteRequest;
import com.tamogochi.server.dto.request.PetPostRequest;
import com.tamogochi.server.dto.response.PetCreateResponse;
import com.tamogochi.server.dto.response.PetDeleteResponse;
import com.tamogochi.server.dto.response.PetPostResponse;
import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.mapper.PetMapper;
import com.tamogochi.server.service.api.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private final PetMapper petMapper;

    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PetCreateResponse create(@Valid @RequestBody PetCreateRequest request) {
        Pet pet = petService.create(request.getUserId(), request.getName());
        return new PetCreateResponse(petMapper.toDto(pet));
    }

    @PostMapping(value = "/delete")
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
