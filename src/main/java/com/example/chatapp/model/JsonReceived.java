package com.example.chatapp.model;

public class JsonReceived {

  ChatAppMessages message;

  public ChatAppMessages getMessage() {
    return message;
  }

  Client client;

  public JsonReceived() {
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setMessage(ChatAppMessages message) {
    this.message = message;
  }
}
