package com.example.journalApp.service;

import com.example.journalApp.Entity.User;
import com.example.journalApp.Repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserEntryService {
    @Autowired
    public UserEntryRepository userEntryRepository;

    public List<User> getAllUsers(){
      return userEntryRepository.findAll();
    }

    public void saveUser(User user){
        userEntryRepository.save(user);
    }

    public Optional<User> findbyId(ObjectId id){
        return userEntryRepository.findById(id);
    }

    public void deletebyid(ObjectId id){
        userEntryRepository.deleteById(id);
    }

    public User findByUserName(String User){
        return userEntryRepository.findByusername(User);

    }
}
