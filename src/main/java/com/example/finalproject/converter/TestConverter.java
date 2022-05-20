package com.example.finalproject.converter;

import com.example.finalproject.models.Question;
import com.example.finalproject.models.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class TestConverter implements Converter<String, Test> {

    @Override
    public Test convert(String source) {
        String[] resource =source.split(",");
        return new Test(Long.parseLong(resource[0]),resource[1]);
    }
}
