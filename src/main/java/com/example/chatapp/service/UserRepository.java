package com.example.chatapp.service;

import com.example.chatapp.model.NameOfUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<NameOfUser, Long> {
}
