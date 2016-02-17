package com.app.controller;

import com.app.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by riva on 03.02.16.
 */
@RestController
@RequestMapping("/androidlogin")
public class AndroidController {

    @Autowired
    JdbcTemplate jdbcTemp;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Users sendUserProfile(@RequestBody Users request) {

        Users user = getUserbyName(request.getName());
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }


    public Users getUserbyName(String userName) {
        String sql = "SELECT * FROM users WHERE name = ?";

        Users user = null;
        try {
            user = jdbcTemp.queryForObject(sql,
                    new Object[]{userName}, BeanPropertyRowMapper.newInstance(Users.class));

        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }


}
