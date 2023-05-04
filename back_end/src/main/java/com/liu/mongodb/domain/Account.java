package com.liu.mongodb.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Account {
    private String username;
    private String password;
}
