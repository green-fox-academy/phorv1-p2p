package com.example.chatapp.controller;

import com.example.chatapp.model.Logging;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class ChatAppMainController {

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public String notFound() {
    System.out.println("ERROR");
    return "redirect:/";
  }

  @RequestMapping(value = "/")
  public String mainPage() {

    String currentLogLevel = System.getenv("CHAT_APP_LOGLEVEL");

    if (currentLogLevel != null && currentLogLevel.equals("INFO")) {
      System.out.println(new Logging("INFO","/", "GET", ""));
    }
    return "index";
  }
}
