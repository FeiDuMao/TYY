package com.tyy.jpa.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import java.util.List;

public class JpaParentTagConverter implements AttributeConverter<List<ParentTag>, String> {

    private static final ObjectMapper mapper;
    private static final JavaType type;

    static {
        mapper = new ObjectMapper();
        type = mapper.getTypeFactory().constructParametricType(List.class, ParentTag.class);
    }

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(List<ParentTag> attribute) {
        return mapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public List<ParentTag> convertToEntityAttribute(String dbData) {
        if (dbData == null) return List.of();
        return mapper.readValue(dbData, type);
    }
}
