package com.example.chatapp.controller;

import com.example.chatapp.model.ChatAppMessages;
import com.example.chatapp.model.Client;
import com.example.chatapp.model.JsonReceived;
import com.example.chatapp.model.StatusError;
import com.example.chatapp.model.StatusOk;
import com.example.chatapp.service.MessagesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
  StatusOk statusOk;
  @Autowired
  StatusError statusError;
  @Autowired
  Client client;

  RestTemplate restTemplate = new RestTemplate();

  String url = "https://lit-caverns-63725.herokuapp.com/api/message/receive";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Object receiveMessage(@RequestBody JsonReceived jsonReceived) {
    List<String> errors = new ArrayList<>();

    if (StringUtils.isEmpty(jsonReceived.getMessage().getText())) {
      errors.add("message.text");
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getUsername())) {
      errors.add("message.username");
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getTimestamp())) {
      errors.add("message.timestamp");
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getId())) {
      errors.add("message.id");
    }
    if (StringUtils.isEmpty(jsonReceived.getClient().getId())) {
      errors.add("client.id");
    }
    if (!jsonReceived.getClient().getId().equals("phorv1")) {
      if (errors.size() == 0) {
        statusOk.setStatus("ok");
        messagesRepository.save(jsonReceived.getMessage());
        restTemplate.postForObject(url, jsonReceived, StatusOk.class);
      } else {
        statusError.setStatus("error");
        statusError.setMessage(errors);
      }
    } else {
      statusOk.setStatus("ok");
    }
    return (errors.size() == 0) ? statusOk : statusError;
  }
}

