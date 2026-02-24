package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class User3 {

    @Id
    public Long id;

    public String name;
    public String email;
    public String password;
    public String role;
    public Date createdAt;
}
