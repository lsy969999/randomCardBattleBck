package l.s.y.randomCardBattle.sample.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TB_SAMPLE")
@SequenceGenerator(name = "SAMPLE_SEQ_GENERATOR", sequenceName = "TB_SAMPLE_SEQ", initialValue = 1, allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Sample extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAMPLE_SEQ_GENERATOR")
    @Column(name = "SAMPLE_SN")
    private Long sampleSn;

    @Column(name = "SAMPLE_NAME")
    private String sampleName;

    @Builder
    public Sample(String sampleName){
        this.sampleName = sampleName;
    }

}
