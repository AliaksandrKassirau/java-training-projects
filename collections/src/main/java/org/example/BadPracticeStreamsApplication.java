package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class BadPracticeStreamsApplication {


    public static void main(String[] args) {
        List<String> ordered = Arrays.asList("a1",  "a3", "a2", "a2", "a1", "a2", "a2");
        Set<String> collect = ordered.stream()
                .collect(Collectors.toCollection(HashSet::new));
    }
}

