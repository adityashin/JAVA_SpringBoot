package com.example.journalApp.Controller;

import com.example.journalApp.Entity.User;
import com.example.journalApp.service.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/user")
public class UserController {
    @Autowired
    public UserEntryService userEntryService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> allusers = userEntryService.getAllUsers();
        if(allusers.equals("null") || !allusers.isEmpty()){
            return new ResponseEntity<>(allusers,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
        userEntryService.saveUser(user);
        System.out.println("User Created");
        return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getUserByid(@PathVariable ObjectId id){
        Optional<User> getuserbyid = userEntryService.findbyId(id);
        if(getuserbyid.isPresent()){
            return new ResponseEntity<>(getuserbyid,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(getuserbyid,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteuserbyId(@PathVariable ObjectId id){
        if(userEntryService.findbyId(id).isPresent()){
            userEntryService.deletebyid(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("name/{userName}")
    public ResponseEntity<?> updateuserbyId(@PathVariable String userName,@RequestBody User user){
        User userinDB = userEntryService.findByUserName(userName);
        if(userinDB!=null) {
            userinDB.setUsername(user.getUsername());
            userinDB.setPassword(user.getPassword());
            userEntryService.saveUser(userinDB);
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

