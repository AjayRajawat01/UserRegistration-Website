package com.example.website.domain;

import org.springframework.stereotype.Component;

@Component
public class SupportUserMessage implements UserMessage{

    String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public void setUserId(int userId) {
        this.Message = "Hi welcome to support " + String.valueOf(userId);
    }
}
