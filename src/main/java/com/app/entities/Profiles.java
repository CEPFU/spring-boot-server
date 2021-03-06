package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by riva on 04.02.16.
 */
@Entity
@Table(name = "profiles")
public class Profiles {


    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String description;

    @NotNull
    @ManyToOne
    private Users user;


    // getters/setters

    public long getID() {
        return id;
    }

    public void setID(long newID) {
        id = newID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUserid() {
        return user;
    }

    public void setUserid(Users userid) {
        this.user = user;
    }
}


