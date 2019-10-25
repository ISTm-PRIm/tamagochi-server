package com.tamogochi.server.repository;

import com.tamogochi.server.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, String> {
}
