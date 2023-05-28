package l.sy.randomCardBattle._sample.domain.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SampleEnumConverter implements AttributeConverter<SampleEnum, String> {
    @Override
    public String convertToDatabaseColumn(SampleEnum sampleEnum) {
       if(sampleEnum == null){
           return null;
       }
       return sampleEnum.getCode();
    }

    @Override
    public SampleEnum convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        return Stream.of(SampleEnum.values())
                .filter(c->c.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
