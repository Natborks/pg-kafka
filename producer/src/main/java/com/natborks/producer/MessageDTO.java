package com.natborks.producer;


public class MessageDTO {
    int id;
    String data;

    public MessageDTO(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public MessageDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
