package com.example.journalApp.Controller;

import com.example.journalApp.Entity.JournalEntry;
import com.example.journalApp.Entity.User;
import com.example.journalApp.service.JournalEntryService;
import com.example.journalApp.service.UserEntryService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserEntryService userEntryService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getAllJournals(@PathVariable String username){
        User user = userEntryService.findByUserName(username);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null || all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/{username}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry,@PathVariable String username){
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(journalEntry,username);
            System.out.println("Created");
            return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myid}")
    public ResponseEntity<JournalEntry> getJournalbyID(@PathVariable ObjectId myid){
        Optional<JournalEntry> journalEntry = journalEntryService.getJournalByID(myid);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("id/{myid}/{username}")
    public ResponseEntity<?> deletejournalbyid(@PathVariable ObjectId myid,@PathVariable String username){
        journalEntryService.deletebyId(myid,username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myid}/{username}")
    public ResponseEntity<?> updateJournalbyid(
            @PathVariable ObjectId myid,
            @RequestBody JournalEntry myjournal,
            @PathVariable String username
    ){
        JournalEntry old = journalEntryService.getJournalByID(myid).orElse(null);
        if (old!=null){
             old.setContent(myjournal.getContent()!=null && !myjournal.getContent().equals("") ? myjournal.getContent() : old.getContent());
             old.setTitle(myjournal.getTitle()!=null && !myjournal.getTitle().equals("") ? myjournal.getTitle() : old.getTitle());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<JournalEntry>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
