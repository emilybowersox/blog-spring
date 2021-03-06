package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255, unique = true)
    private String username;


    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;


// empty constructor for the Spring framework to use (not for developers- for Spring)
    public User(){}

    //The constructor User(User copy) defined in this class is a common pattern in Java called a copy constructor.
    // It is used as an alternative to cloning an object.
    // Instead of using the method clone, we create a new object using the current values of another.
    // This will be used in order to fulfill the contract defined by the interfaces in the security package.
    public User(User copy){
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    //constructor for "read"
    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //constructor for "insert"
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

        //getters
        public long getId() {return id;}
        public String getUsername() {return username;}
        public String getEmail() {return email;}
        public String getPassword() {return password;}

        //setters
        public void setId(long id) {this.id=id;}
        public void setUsername(String username) {this.username=username;}
        public void setEmail(String email) {this.email=email;}
        public void setPassword(String password) {this.password=password;}

    }


