package com.intern.demo.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping
    public List<Customer> getAllCustomer(){
        return List.of(
                new Customer(UUID.randomUUID(),
                        "Yi",
                        "Liu",
                        "yliu511@jh.edu",
                        Customer.Gender.MALE),
                new Customer(UUID.randomUUID(),
                        "yi",
                        "liu",
                        "yliu511@jhu.edu",
                        Customer.Gender.FEMALE)
        );
    }
}
