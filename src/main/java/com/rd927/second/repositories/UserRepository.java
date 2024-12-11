package com.rd927.second.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rd927.second.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    User findByUsername(String username);
}
