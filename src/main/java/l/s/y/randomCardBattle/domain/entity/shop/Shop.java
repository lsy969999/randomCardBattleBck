package l.s.y.randomCardBattle.domain.entity.shop;

import l.s.y.randomCardBattle.domain.entity.common.BaseEntity;

import java.time.LocalDateTime;

public class Shop extends BaseEntity {
    private Long shopSn;
    private Integer jina;
    private LocalDateTime salesStartDate;
    private LocalDateTime salesEndDate;
    private Integer quantity;

}
