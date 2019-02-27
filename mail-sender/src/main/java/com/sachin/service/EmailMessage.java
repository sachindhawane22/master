package com.sachin.service;
public class EmailMessage {
    String to_address;
    String subject;
    String body;

    public String getTo_address() {
        return to_address;
    }

    public String getSubject() {
        return subject;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}