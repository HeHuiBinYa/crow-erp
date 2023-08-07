package com.crow.formatters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocaDataFormatter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime parse = LocalDateTime.parse(source.replace("T"," "), dateTimeFormatter);

        System.out.println(parse);

        return parse;
    }
}
