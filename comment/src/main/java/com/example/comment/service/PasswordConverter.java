package com.example.comment.service;

import jakarta.persistence.AttributeConverter;

public class PasswordConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return null;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return null;
    }
}
