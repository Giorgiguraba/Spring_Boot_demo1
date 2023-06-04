package com.example.project.demoProject.controller;

import com.example.project.demoProject.dto.AddUser;
import com.example.project.demoProject.dto.UppdateUser;
import com.example.project.demoProject.entities.User;
import com.example.project.demoProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/user")//http://localhost:3000/user
public class Usercontroller {
    Map<String, User> users;
    private UserService userService;
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", required = false) String sort){
        return "get User page" + page + "limiti " + limit;
    }
    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable String user){
//        User testUser = new User();
//        testUser.setPassword("0111022");
//        testUser.setEmail("girogi@g.2");
//        testUser.setFirstName("giorgi");
//        testUser.setLastName("gurabana");
//        testUser.getUserId();
        if (users.containsKey(user)){
            return new ResponseEntity<>(users.get(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping(path = "/{userAdd}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> uppdateUser(@Valid @RequestBody AddUser addUser){
        User testUserToPost = new User();
        testUserToPost.setLastName(addUser.getLastName());
        testUserToPost.setFirstName(addUser.getFirstName());
        testUserToPost.setEmail(addUser.getEmail());
        testUserToPost.setPassword(addUser.getPassword());//i have to look again this line to be shoure i need it

        //creating random userId's and seting them
        String userId = UUID.randomUUID().toString();
        testUserToPost.setUserId(userId);
        //
        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, testUserToPost);

        return new ResponseEntity<User>(testUserToPost, HttpStatus.OK);
    }
    @PutMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User uppdateUser(@PathVariable String userId, @RequestBody UppdateUser uppdateUser){
        User storedUserDeteils = users.get(userId);

        storedUserDeteils.setFirstName(uppdateUser.getFirstName());
        storedUserDeteils.setLastName(uppdateUser.getLastName());

        users.put(userId, storedUserDeteils);

        return storedUserDeteils;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        //deleting hashmap
        users.remove(userId);

        return ResponseEntity.noContent().build();
    }
}

