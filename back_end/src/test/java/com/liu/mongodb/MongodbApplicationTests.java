package com.liu.mongodb;

import com.liu.mongodb.domain.Person;
import com.liu.mongodb.domain.PersonController;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
//    @Test
//    void save() {
//        //java 中类对应 MongoDB 集合
//        Person person = new Person();
//        person.setId("11122");
//        person.setName("NAME");
//        mongoTemplate.save(person);
//    }

    @InjectMocks
    private PersonController personController;
@Test
public void testAddLabelToPerson() {
    // create a new Person document in the collection
    String username = "yiliu";
    // add a new label to the existing label array
    String newLabel = "gresesn";
    Query query = new Query(Criteria.where("username").is(username));
    Update update = new Update().addToSet("label", newLabel);
    mongoTemplate.updateFirst(query, update, Person.class);

    // verify that the label was added to the person's document in the collection
    Document updatedPersonDocument = mongoTemplate.getCollection("person").find(Filters.eq("username", username)).first();
    List<String> updatedLabels = (List<String>) updatedPersonDocument.get("label");
}

    @Test
    void update(){
        Query query = new Query(Criteria.where("id").is("111"));
        Update update = new Update().set("name", "张张三");
        //这里可以继续set更改多个数据
        mongoTemplate.updateFirst(query, update, Person.class);
        //更新查询返回结果的第一条
    }
    @Test
    void delete(){
        Query query = new Query(Criteria.where("id").is("11122"));
        mongoTemplate.remove(query, Person.class);
    }

    @Test
    void testRemoveLabel() {
        // create a new Person document in the collection
        String username = "yiliu";
        String labelToRemove = "sss";
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update().pull("label", labelToRemove);
        mongoTemplate.updateFirst(query, update, Person.class);

    }




    @Test
    void findBy(){
        Query query = new Query(Criteria.where("name").is("张张三"));
        Person person = mongoTemplate.findOne(query, Person.class);
        System.out.println(person);
    }


}
