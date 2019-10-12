package com.tamogochi.server.mapper;

import com.tamogochi.server.configuration.MappersConfiguration;
import com.tamogochi.server.dto.entity.PetDTO;
import com.tamogochi.server.entity.Pet;
import org.mapstruct.Mapper;

@Mapper(config = MappersConfiguration.class)
public interface PetMapper {
    PetDTO toDto(Pet pet);
}
