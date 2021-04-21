package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsReduceApplication {

    public static void main(String[] args) {
        List<Integer> collection = Arrays.asList(1, 2, 21, 3, 8, 4, 2);
        String integer = collection.stream()
                .map(Object::toString)
                .collect(Collectors.joining("+"));
    }
}
