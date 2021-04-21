package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorApplication {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("El1", "El2", "El3", "El4", "El5"));
        Iterator<String> iterator = strings.iterator();
        strings.listIterator();

        while (iterator.hasNext()) {
            String currentElement = iterator.next();
            System.out.println(currentElement);
            iterator.remove();
        }
    }
}
