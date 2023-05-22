package l.s.y.randomCardBattle.sample.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SampleEnum {
    SAMPLE1("S1"), SAMPLE2("S2");
    private String code;
}
