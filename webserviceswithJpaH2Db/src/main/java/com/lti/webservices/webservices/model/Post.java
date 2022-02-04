package com.lti.webservices.webservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Post {
   @Id
   @GeneratedValue
    private  Integer id;
    private String description;
    //One User can do many post
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
    Post(){}

    public Post(Integer id, String description, User user) {

        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
