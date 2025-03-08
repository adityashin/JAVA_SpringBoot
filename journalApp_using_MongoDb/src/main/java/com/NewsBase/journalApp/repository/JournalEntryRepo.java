package com.NewsBase.journalApp.repository;

import com.NewsBase.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository; 

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String> {
}
