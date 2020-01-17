package ru.vinokurov.chat.controller;

import ru.vinokurov.chat.model.MessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/newMessage")
    @SendTo("/general/public")
    public MessageModel sendMessage(@Payload MessageModel messageModel) {
        return messageModel;
    }

    @MessageMapping("/addUser")
    @SendTo("/general/public")
    public MessageModel addUser(@Payload MessageModel messageModel,
                                SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", messageModel.getSender());
        return messageModel;
    }



}
