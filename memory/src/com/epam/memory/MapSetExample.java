package com.epam.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapSetExample {

    public static void main(String[] args) {
        Map<Person, Document> dictionaryPerson= new HashMap<>();
        dictionaryPerson.put(new Person("1"), new Document(""));
        dictionaryPerson.put(new Person("1"), new Document(""));
        dictionaryPerson.put(new Person("3"), new Document(""));

        Document document = dictionaryPerson.get(new Person("1"));
    }
}

class Person {
    private String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Document {
    private String info;

    public Document(String info) {
        this.info = info;
    }
}