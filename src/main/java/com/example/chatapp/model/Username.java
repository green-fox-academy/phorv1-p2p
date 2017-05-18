package com.example.chatapp.model;

import com.example.chatapp.service.UserRepository;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
public class NameOfUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String username;

  public NameOfUser() {
  }

  public NameOfUser(String username) {
    this.username = username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }
}
