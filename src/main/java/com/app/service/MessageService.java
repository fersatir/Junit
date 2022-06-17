package com.app.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.app.repository.MessageRepository;
public class MessageService {
	
    private MessageRepository repository; //message repository'den variable oluşturuyoruz
    
    public MessageService(MessageRepository repository) {
        this.repository=repository;
    }
    
    //tüm mesajları döndürür
    public List<String> getMessages(){
        try {
            return repository.getMessages();
        } catch (SQLException e) {
         
            return Arrays. asList();
        }
    }
    
    // 5'den az olan mesajları döndürür
    public List<String> getMessageWithLengthLessThanFive(){
        
        try {
            return repository.getMessages().stream().filter(m->m.length()<5)
            .collect(Collectors.toList());
        } catch (SQLException e) {
           
            return Arrays. asList();
        }
         
    }
    
    
    public void addMessage(String message) {
        repository.addMessage(message);
    }
    
    public void removeMessage(String message) {
        repository.removeMessage(message);
    }
}