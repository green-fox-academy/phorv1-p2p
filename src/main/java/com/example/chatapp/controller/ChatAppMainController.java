package com.example.chatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatAppMainController {

  @RequestMapping(value = "/")
  public String mainPage() {
    return "index";
  }

}
