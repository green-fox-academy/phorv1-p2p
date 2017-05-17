package com.example.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User{

  String username;

  public User(String username) {
    this.username = username;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
}
