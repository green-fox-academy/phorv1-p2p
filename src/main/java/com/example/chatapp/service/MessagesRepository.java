package com.example.chatapp.service;

import com.example.chatapp.model.ChatAppMessages;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<ChatAppMessages, Long> {

  List<ChatAppMessages> findAllByOrderByTimestampDesc();
}
