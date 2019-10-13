package com.tamogochi.server.controller;

import com.tamogochi.server.dto.request.PetCreateRequest;
import com.tamogochi.server.dto.response.PetCreateResponse;
import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.mapper.PetMapper;
import com.tamogochi.server.service.api.PetService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private final PetMapper petMapper;

    @ApiOperation(value = "Create a pet", response = PetCreateResponse.class)
    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PetCreateResponse create(@Valid @RequestBody PetCreateRequest request) {
        Pet pet = petService.create(request.getUserId(), request.getName());
        return new PetCreateResponse(petMapper.toDto(pet));
    }
}
