package com.NewsBase.journalApp.Controllers;

import com.NewsBase.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Methods in controller should be Public so that they can be accessed by SpringFramework and other HTTP Requests.

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {


    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }

    @PostMapping
    public Boolean createJournalEntry(@RequestBody JournalEntry myentry) {
        return null;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryId(@PathVariable Long myid) {
        return null;
    }


    @DeleteMapping("id/{myid}")
    public JournalEntry deleteJournalEntry(@PathVariable Long myid) {
        return null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalByid(@PathVariable Long id, @RequestBody JournalEntry myid) {
        return null;
    }


}
