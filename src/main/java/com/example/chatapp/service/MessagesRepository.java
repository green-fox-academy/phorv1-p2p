package com.example.chatapp.service;

import com.example.chatapp.model.ChatAppMessages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository  extends CrudRepository<ChatAppMessages, Long>{

}
