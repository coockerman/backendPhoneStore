package com.example.phoneStore.repository;

import com.example.phoneStore.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUserName(String username);

//    User findByUserName(String username);
    public User findUserByUserName(String username);

}
