package org.example;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map<Integer, String> stringsMaps = new TreeMap<>((value1, value2) -> {
            if (value2 >= value1) {
                return 1;
            } else {
                return -1;
            }
        });
        stringsMaps.put(45, "1");
        stringsMaps.put(18, "2");
        stringsMaps.put(80, "3");

        for (Map.Entry<Integer, String> entry : stringsMaps.entrySet()) {
            System.out.println(String.format("%d %s", entry.getKey(), entry.getValue()));
        }
    }
}
