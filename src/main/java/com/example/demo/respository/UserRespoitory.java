package com.example.demo.respository;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespoitory extends CrudRepository<User, Long> {
}
