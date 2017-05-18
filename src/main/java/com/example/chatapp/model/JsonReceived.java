package com.example.chatapp.model;

public class JsonReceived {

  Client client;
  ChatAppMessages chatAppMessages;

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public ChatAppMessages getChatAppMessages() {
    return chatAppMessages;
  }

  public void setChatAppMessages(ChatAppMessages chatAppMessages) {
    this.chatAppMessages = chatAppMessages;
  }
}
