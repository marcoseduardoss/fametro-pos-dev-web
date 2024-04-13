package br.fametro.xpto.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Esta classe define um conversor de atributo personalizado para a 
 * JPA (Java Persistence API), usando as anotações do Jakarta Persistence. 
 * Esse conversor é especificamente projetado para converter objetos do tipo LocalDateTime 
 * (da API de data e hora do Java) para String ao armazená-los em um banco de dados, 
 * e vice-versa ao recuperá-los do banco de dados.
 */

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalDateTime locDateTime) {
        return locDateTime == null ? null : locDateTime.toString();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String sqlTimestamp) {
        return sqlTimestamp == null ? null : LocalDateTime.parse(sqlTimestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
