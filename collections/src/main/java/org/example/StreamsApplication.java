package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApplication {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(20, "Name1"),
                new Person(18, "Name2"),
                new Person(25, "Name2"),
                new Person(23, "Name2"),
                new Person(30, "Name3")
        );

        List<Person> personsOver21 = people.stream()
                .filter(person -> person.age >= 21)
                .collect(Collectors.toList());

        Map<String, List<Person>> peopleByNamesOver21 = people.stream()
                .filter(person -> person.age >= 21)
                .collect(Collectors.groupingBy(Person::getName));

        people.stream()
                .filter(person -> person.age >= 21)
                .findFirst();
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
