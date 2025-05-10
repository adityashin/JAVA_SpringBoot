package com.example.journalApp.service;

import com.example.journalApp.Entity.JournalEntry;
import com.example.journalApp.Entity.User;
import com.example.journalApp.Repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired UserEntryService userEntryService;

    public List<JournalEntry> getAll(){

        return journalEntryRepo.findAll();
    }

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username){

        User user = userEntryService.findByUserName(username);
        JournalEntry saved =  journalEntryRepo.save(journalEntry);
        user.getJournalEntries().add(saved);
        userEntryService.saveUser(user);
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }

    public Optional<JournalEntry> getJournalByID(ObjectId mid){

        return journalEntryRepo.findById(mid);
    }

    public void deletebyId(ObjectId mid,String username){
        User user = userEntryService.findByUserName(username);
        user.getJournalEntries().removeIf(x -> x.getId().equals(mid));
        userEntryService.saveUser(user);
        journalEntryRepo.deleteById(mid);
    }
}
