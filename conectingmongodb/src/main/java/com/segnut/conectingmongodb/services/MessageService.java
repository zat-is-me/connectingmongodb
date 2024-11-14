package com.segnut.conectingmongodb.services;

import com.segnut.conectingmongodb.dto.MessageResponse;
import com.segnut.conectingmongodb.entities.Message;
import com.segnut.conectingmongodb.repositories.MessageReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageReporitory messageReporitory;

    @Autowired
    private Message message;

    @Autowired
    private MessageResponse messageResponse;

    public MessageResponse getMessage(Integer messageId){
       message = messageReporitory.findById(messageId).get();
       messageResponse.setMessage(message.getMessage());
        return messageResponse;
    }

    public Message saveMessage(Message message){
        return messageReporitory.save(message);
    }
}
