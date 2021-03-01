package com.epam.memory;

import java.util.HashMap;
import java.util.Map;

public class StaticContextApplication {
    public static String STATIC_EXAMPLE;
    public static Map<String, String> REGISTRY = new HashMap<>() {{

    }};

    private int a = 15;


    static {
           REGISTRY.put("KEY", "VALUE");
    }
}
