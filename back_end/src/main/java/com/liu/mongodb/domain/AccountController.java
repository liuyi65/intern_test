package com.liu.mongodb.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController // Use @RestController instead of @Controller
public class AccountController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/person/{username}")
    public ResponseEntity<Person[]> getPersonByUsername(@PathVariable String username) {
        Query query = new Query(Criteria.where("username").is(username));
        List<Person> relatedPersons = mongoTemplate.find(query, Person.class, "person");

        if (relatedPersons.isEmpty()) {
            // If no related persons are found, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }

        // Convert the list of related persons to an array called "label"
        Person[] label = relatedPersons.toArray(new Person[relatedPersons.size()]);

        // Return a 200 OK response with the "label" array
        return ResponseEntity.ok().body(label);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");
        Query query = new Query(Criteria.where("username").is(username));
        Account userAccount = mongoTemplate.findOne(query, Account.class, "userAccount");

        if (userAccount != null && userAccount.getPassword().equals(password)) {
            return ResponseEntity.ok().body("Login successful.");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
    }



}
