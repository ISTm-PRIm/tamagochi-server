package com.tamogochi.server.repository;

import com.tamogochi.server.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
    Pet getPetById(String id);
}
