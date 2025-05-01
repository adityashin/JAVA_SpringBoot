package com.example.journalApp.Controller;

import com.example.journalApp.Entity.JournalEntry;
import com.example.journalApp.service.JournalEntryService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<?> getAllJournals(){
        List<JournalEntry> all = journalEntryService.getAll();
        if(all != null || all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry){
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(journalEntry);
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

    @DeleteMapping("id/{myid}")
    public ResponseEntity<?> deletejournalbyid(@PathVariable ObjectId myid){
        journalEntryService.deletebyId(myid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myid}")
    public ResponseEntity<?> updateJournalbyid(@PathVariable ObjectId myid,@RequestBody JournalEntry myjournal){
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
