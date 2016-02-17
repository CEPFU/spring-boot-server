package com.app.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by riva on 25.01.16.
 */
@Entity
@Table(name = "users")
public class Users {


    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    // Public methods
    public Users() {
    }


    // getters/setters

    public long getID() {
        return id;
    }

    public void setID(long newID) {
        id = newID;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        name = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        password = userPassword;
    }


}