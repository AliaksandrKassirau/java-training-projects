package com.epam.webapplication.mvc;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelAndView {
    private String view;
    private Map<String, Object> attributes = new HashMap<>();

    public ModelAndView setAttribute(String key, Object attribute) {
        this.attributes.put(key, attribute);
        return this;
    }

    @Override
    public String toString() {
        return "ModelAndView{" +
                "view='" + view + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
