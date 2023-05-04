package com.liu.mongodb.domain;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.UpdateOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.Map;
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping
    public List<Person> getAllLabel() {
        List<Person> persons = mongoTemplate.findAll(Person.class);
        return persons;
    }
    @PostMapping
    public void addLabel(@RequestBody Person person) {
        String username = person.getUsername();
        String newLabel = person.getNewLabel();
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update().addToSet("label", newLabel);
        mongoTemplate.updateFirst(query, update, Person.class);
    }

    @DeleteMapping("removeLabel")
    public void removeLabel(@RequestBody Person person) {
        String username = person.getUsername();
        String labelToRemove = person.getNewLabel();
        System.out.println("Removing label '" + labelToRemove + "' for user '" + username + "'");
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update().pull("label", labelToRemove);
        mongoTemplate.updateFirst(query, update, Person.class);
    }

    @PutMapping("updateLabel")
    public void updateLabel(@RequestBody Map<String, String> updateLabelRequest) {
        String name = updateLabelRequest.get("username");
        String labelToUpdate = updateLabelRequest.get("oldLabel");
        String labelUpdate = updateLabelRequest.get("newLabel");
        System.out.println("name: " + name + ", labelToUpdate: " + labelToUpdate + ", labelUpdate: " + labelUpdate);
        Query query = new Query(Criteria.where("username").is(name).and("label").is(labelToUpdate));
        Update update = new Update().set("label.$", labelUpdate);
        mongoTemplate.updateFirst(query, update, Person.class);
    }
}
