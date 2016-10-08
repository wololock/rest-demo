package com.github.wololock.people;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public final class People {

    public static List<Person> get() {
        return Arrays.asList(
                new Person("100001", "Joe", "Doe", LocalDate.parse("1965-01-01")),
                new Person("100003", "Mark", "Smith", LocalDate.parse("1971-04-12")),
                new Person("100021", "Adam", "J. Adams", LocalDate.parse("1988-07-25"))
        );
    }
}
