package com.tamogochi.server.repository;

import com.tamogochi.server.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User getUserById(String id);
}
