package l.s.y.randomCardBattle.domain.entity.battlecard;

import jakarta.persistence.*;
import l.s.y.randomCardBattle.domain.entity.common.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "TB_BATTLE_CARD")
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "BATTLE_CARD_SEQ_GENERATOR", sequenceName = "TB_BATTLE_CARD_SEQ", initialValue = 1, allocationSize = 1)
public class BattleCard extends BaseEntity {
    @Id
    @GeneratedValue(generator = "BATTLE_CARD_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "BATTLE_CARD_SN")
    private Long battleCardSn;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "GRADE")
    private Grade grade;

    @Column(name = "DESC")
    private String desc;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MADE_IN")
    private String madeIn;

    @Column(name = "DAMAGE")
    private Integer damage;

    @Column(name = "HEALTH")
    private Integer health;
}
