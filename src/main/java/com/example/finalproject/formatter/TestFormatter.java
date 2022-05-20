package com.example.finalproject.formatter;

import com.example.finalproject.models.Test;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class TestFormatter implements Formatter<Test> {

    @Override
    public Test parse(String text, Locale locale) throws ParseException {
        if(text != null) {
            String[] resource = text.split(",");
            if(resource.length == 2 || resource.length == 4) {
                Test test = new Test();
                test.setId(Long.parseLong(resource[0]));
                test.setName(resource[1]);
                return test;
            }
        }
        return null;
    }

    @Override
    public String print(Test test, Locale locale) {
        if(test == null) {
            return "";
        }
        return test.toString();
    }
}
