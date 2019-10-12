package com.tamogochi.server.repository;

import com.tamogochi.server.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, String> {
}
