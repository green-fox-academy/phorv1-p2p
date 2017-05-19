package com.example.chatapp.controller;

import com.example.chatapp.model.JsonReceived;
import com.example.chatapp.model.Status;
import com.example.chatapp.service.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatAppRestController {

  @Autowired
  MessagesRepository messagesRepository;
  @Autowired
  Status status;

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody JsonReceived jsonReceived) {

    messagesRepository.save(jsonReceived.getMessage());
    status.setStatus("ok");
    return status;
  }

  String url = "https://chat-p2p.herokuapp.com/api/message/receive";
  RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/add")
  public JsonReceived index(
          @RequestParam(name = "title") String title,
          @RequestParam(name = "href") String href) {

    JsonReceived p = new JsonReceived(title, href);

    JsonReceived newPost = restTemplate.postForObject(url, p, JsonReceived.class);
    return newPost;
  }

}
