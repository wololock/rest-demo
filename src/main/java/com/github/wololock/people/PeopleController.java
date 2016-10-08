package com.github.wololock.people;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/people", produces = "application/json")
public final class PeopleController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAll() {
        return People.get();
    }
}
