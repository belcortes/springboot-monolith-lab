package com.example.testingspringbootmonolith.repositories;

import com.example.testingspringbootmonolith.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

}