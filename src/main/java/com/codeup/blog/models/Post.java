package com.codeup.blog.models;

//This class will ultimately represent a POST record from our database.
// The class should have private properties and getters and setters for a title and body.
public class Post {

private String title;
private String body;

//getters
public String getTitle(){
    return title;
}
public String getBody(){
    return body;
}

//setters
    public void setTitle(String title){
    this.title = title;
    }

    public void setBody(String body){
    this.body = body;
    }


}
