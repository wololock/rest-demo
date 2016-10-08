package com.github.wololock.people

import spock.lang.Specification

import java.time.LocalDate

class PersonSpec extends Specification {

    def "should use random UUID while creating new Person"() {
        when:
        Person person = Person.create("Joe", "Doe", LocalDate.parse("1965-12-03"))

        then:
        person.id != null

        and:
        person.firstName == "Joe"

        and:
        person.lastName == "Doe"

        and:
        person.birthDate == LocalDate.parse("1965-12-03")
    }
}
