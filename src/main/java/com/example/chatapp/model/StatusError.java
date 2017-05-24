package com.example.chatapp.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class StatusError {

  @Getter
  @Setter
  String status;
  @Getter
  String message;

  public void setMessage(List<String> message) {
    this.message = "Missing field(s) ";
    for (String entry : message) {
    this.message += entry + ", ";
    }
    this.message = this.message.substring(0, this.message.length() - 2);
  }

  public StatusError(String message) {
    this.status = "error";
    this.message = message;
  }

}
