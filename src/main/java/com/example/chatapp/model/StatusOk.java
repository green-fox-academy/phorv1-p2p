package com.example.chatapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class StatusOk {

  @Setter
  @Getter
  String status;

  public StatusOk() {
    this.status = "ok";
  }
}
