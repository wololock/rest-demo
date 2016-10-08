package com.github.wololock.people;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UsersController {

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return People.get()
                .stream()
                .map(User::new)
                .collect(Collectors.toList());
    }
}
