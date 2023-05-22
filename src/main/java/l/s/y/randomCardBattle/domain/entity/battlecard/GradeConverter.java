package l.s.y.randomCardBattle.domain.entity.battlecard;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GradeConverter implements AttributeConverter<Grade, String> {
    @Override
    public String convertToDatabaseColumn(Grade grade) {
        return grade.getCode();
    }

    @Override
    public Grade convertToEntityAttribute(String dbData) {
        return Stream.of(Grade.values())
                .filter(c->c.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
