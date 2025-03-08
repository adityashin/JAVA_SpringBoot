package com.NewsBase.journalApp.Controllers;

import com.NewsBase.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;
import com.NewsBase.journalApp.entity.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Methods in controller should be Public so that they can be accessed by SpringFramework and other HTTP Requests.
@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
    return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public Boolean createJournalEntry(@RequestBody JournalEntry myentry){
        journalEntries.put(myentry.getId(), myentry);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryId(@PathVariable Long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping("id/{myid}")
    public JournalEntry deleteJournalEntry(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalByid(@PathVariable Long id,@RequestBody JournalEntry myid){
        return journalEntries.put(id,myid);
    }


}
