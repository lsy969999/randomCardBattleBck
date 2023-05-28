package l.sy.randomCardBattle.domain.entity.battlecard;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    COMMON("C", 0.6),
    UNCOMMON("U", 0.3),
    RARE("R", 0.07),
    EPIC("E", 0.02),
    LEGENDARY("L", 0.01);
    private String code;
    private Double a;
}
