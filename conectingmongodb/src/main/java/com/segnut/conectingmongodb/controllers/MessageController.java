package com.segnut.conectingmongodb.controllers;

import com.segnut.conectingmongodb.dto.MessageResponse;
import com.segnut.conectingmongodb.entities.Message;
import com.segnut.conectingmongodb.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message/{id}")
    public ResponseEntity<MessageResponse> getMessage(@PathVariable Integer id){
        return new ResponseEntity<>(messageService.getMessage(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
       return new ResponseEntity<>(messageService.saveMessage(message), HttpStatus.ACCEPTED);
    }
}
