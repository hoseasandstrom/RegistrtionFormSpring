package com.theironyard.controllers;

import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hoseasandstrom on 6/27/16.
 */
@RestController
public class RegistrationFormController {
    @Autowired
    UserRepository users;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return users.findAll();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        users.save(user);
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public void editUser(@RequestBody User user) {
        users.save(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id")int id) {
        users.delete(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id")int id) {
        return users.findOne(id);
    }
}
