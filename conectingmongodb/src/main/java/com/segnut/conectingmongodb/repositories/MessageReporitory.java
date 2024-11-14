package com.segnut.conectingmongodb.repositories;


import com.segnut.conectingmongodb.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MessageReporitory extends MongoRepository<Message, Integer> {

    Optional<Message> findById(Integer id);
}
