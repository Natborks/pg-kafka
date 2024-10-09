package com.natborks.consumer;

import jakarta.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String data;


    public Message(int id, String message) {
        this.id = id;
        this.data = message;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }
}
