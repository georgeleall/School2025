package com.example.week8lab.Repository;

import com.example.week8lab.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
}
