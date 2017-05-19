package com.example.chatapp.controller;

import com.example.chatapp.model.JsonReceived;
import com.example.chatapp.model.Status;
import com.example.chatapp.service.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatAppRestController {

  @Autowired
  MessagesRepository messagesRepository;
  @Autowired
  Status status;

  RestTemplate restTemplate = new RestTemplate();

  String url = "https://chat-p2p.herokuapp.com/api/message/receive";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody JsonReceived jsonReceived) {

    messagesRepository.save(jsonReceived.getMessage());
    status.setStatus("ok");
    restTemplate.postForObject(url, jsonReceived, JsonReceived.class);

    return status;
  }
}
