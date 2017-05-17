package com.example.chatapp.controller;

import com.example.chatapp.model.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatAppMainController {

  @Autowired
  Logging logging;

  @RequestMapping(value = "/")
  public String mainPage() {
    System.out.println(new Logging("/", "GET", ""));
    return "index";
  }
}
