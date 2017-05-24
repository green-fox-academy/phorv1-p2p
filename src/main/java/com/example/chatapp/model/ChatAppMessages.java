package com.example.chatapp.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ChatAppMessages {

  @Id
  @Getter
  @Setter
  long id;

  @Getter
  @Setter
  String username;
  @Getter
  @Setter
  String text;
  @Getter
  @Setter
  Timestamp timestamp;

  public void myIdSet() {
    this.id = getRandomNumber();
  }

  public long getRandomNumber() {
    return (1000000 + (long) (Math.random() * 9000000));
  }
}
