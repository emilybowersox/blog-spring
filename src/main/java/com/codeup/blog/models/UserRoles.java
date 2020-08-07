package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column
    private String role;


    public UserRoles(){
    }


    public long getUserId() {
        return userId;
    }
    public String getRole() {
        return role;
    }


    public void setUserId(long userId) {
        this.userId = userId;
    }
    public void setRole(String role) {
        this.role = role;
    }

}
