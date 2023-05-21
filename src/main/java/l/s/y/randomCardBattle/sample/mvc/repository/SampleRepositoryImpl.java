package l.s.y.randomCardBattle.sample.mvc.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import l.s.y.randomCardBattle.sample.domain.entity.Sample;
import lombok.RequiredArgsConstructor;
import static l.s.y.randomCardBattle.sample.domain.entity.QSample.sample;

import java.util.List;

@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepositoryCustom{
    private final JPAQueryFactory qf;

    @Override
    public List<Sample> sampleAll() {
        return qf.selectFrom(sample).fetch();
    }
}
