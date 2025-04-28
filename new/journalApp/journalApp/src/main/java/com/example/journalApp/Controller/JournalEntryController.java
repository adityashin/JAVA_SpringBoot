package com.example.journalApp.Controller;

import com.example.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll(){
        System.out.println("EVerything returned");
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping()
    public boolean createentry(@RequestBody JournalEntry myentry){
        journalEntries.put(myentry.getId(),myentry);
        return true;
    }

    //get specific journal entry
    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable Long myid ){
        return journalEntries.get(myid);
    }

    @DeleteMapping("id/{myid}")
    public boolean deleteJournalEntryById(@PathVariable Long myid){
       journalEntries.remove(myid);
       return false;
    }

    @PutMapping("id/{myid}")
    public String updateJournalEntryById(@PathVariable Long myid,@RequestBody JournalEntry myEntry){
         journalEntries.put(myid,myEntry);
         return "UPDATED";
    }
}
