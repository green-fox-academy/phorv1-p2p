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

  String url = "https://chat-p2p.herokuapp.com/api/message/receive";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Object receiveMessage(@RequestBody JsonReceived jsonReceived) {
    ChatAppMessages received = new ChatAppMessages();
    List<String> errors = new ArrayList<>();

    if (StringUtils.isEmpty(jsonReceived.getMessage().getText())) {
      errors.add("message.text");
    } else {
      received.setText(jsonReceived.getMessage().getText());
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getUsername())) {
      errors.add("message.username");
    } else {
      received.setUsername(jsonReceived.getMessage().getUsername());
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getTimestamp())) {
      errors.add("message.timestamp");
    } else {
      received.setTimestamp(jsonReceived.getMessage().getTimestamp());
    }
    if (StringUtils.isEmpty(jsonReceived.getMessage().getId())) {
      errors.add("message.id");
    } else {
      received.setId(jsonReceived.getMessage().getId());
    }
    if (StringUtils.isEmpty(jsonReceived.getClient().getId())) {
      errors.add("client.id");
    }
    messagesRepository.save(received);
    restTemplate.postForObject(url, jsonReceived, StatusOk.class);

    statusOk.setStatus("ok");
    statusError.setStatus("error");
    statusError.setMessage(errors);

    return (errors.size()== 0) ? statusOk : statusError;
    }
}

