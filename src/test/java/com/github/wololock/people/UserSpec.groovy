package com.github.wololock.people

import spock.lang.Specification

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class UserSpec extends Specification {

    def "should create User from Person"() {
        given:
        Person person = Person.create("Joe", "Doe", LocalDate.parse("1965-01-01"))

        when:
        User user = new User(person)

        then:
        user.id == person.id

        and:
        user.firstName == person.firstName

        and:
        user.age > 0

        and:
        user.age == person.birthDate.until(LocalDate.now(), ChronoUnit.YEARS)
    }
}
