package com.liu.mongodb.domain;

import lombok.Data;

@Data
public class Person {
    String customerId;
    String username;
    String  newLabel;
    String [] label;
}
