package com.example.chatapp.model;

public class JsonReceived {

  ChatAppMessages message;
  Client client;

  public JsonReceived() {
  }
  public JsonReceived(String href) {
  }

  public ChatAppMessages getMessage() {
    return message;
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
