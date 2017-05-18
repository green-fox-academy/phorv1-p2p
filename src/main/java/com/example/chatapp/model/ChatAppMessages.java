package com.example.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ChatAppMessages {

  @Id
  long id;

  public void setId() {
    this.id = getRandomNumber();
  }

  public long getRandomNumber() {
    return (1000000 + (long) (Math.random() * 9000000));
  }

  @Getter
  @Setter
  String username;
  @Getter
  @Setter
  String newMessage;
}
