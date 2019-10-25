package com.tamogochi.server.repository;

import com.tamogochi.server.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends JpaRepository<Pet, String> {

}
