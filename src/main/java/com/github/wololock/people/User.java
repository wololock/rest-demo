package com.github.wololock.people;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

final class User {

    private final String id;
    private final String firstName;
    private final int age;

    User(final Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.age = person.getBirthDate() != null ? (int) person.getBirthDate().until(LocalDate.now(), ChronoUnit.YEARS) : 0;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return firstName != null ? firstName.equals(user.firstName) : user.firstName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
