package com.example.chatapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Logging {

  LocalDateTime dateAndTime;
  String logLevel;
  String path;
  String method;
  String requestData;

  public Logging(String logLevel, String path, String method,
          String requestData) {
    this.dateAndTime = LocalDateTime.now();
    this.logLevel = logLevel;
    this.path = path;
    this.method = method;
    this.requestData = requestData;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
    return dateAndTime.format(formatter)
            + " " + logLevel
            + " Request " + path
            + " " + method
            + " " + requestData;
  }
}

