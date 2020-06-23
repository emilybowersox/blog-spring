package com.codeup.blog.models;

import javax.persistence.*;

//This class will ultimately represent a POST record from our database.
// The class should have private properties and getters and setters for a title and body.

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String body;

// empty constructor for the Spring framework to use (not for developers- for Spring)
    public Post(){}

    //constructor for "read"
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    //constructor for "insert"
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    //getters
    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    //setters
    public void setId(long id){
        this.id=id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }


}
