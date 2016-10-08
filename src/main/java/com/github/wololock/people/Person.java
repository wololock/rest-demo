package com.github.wololock.people;

import java.time.LocalDate;
import java.util.UUID;

public final class Person {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public static Person create(String firstName, String lastName, LocalDate birthDate) {
        return new Person(UUID.randomUUID().toString(), firstName, lastName, birthDate);
    }

    public Person(String id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null)
            return false;
        return birthDate != null ? birthDate.equals(person.birthDate) : person.birthDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
