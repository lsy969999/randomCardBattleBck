package l.sy.randomCardBattle._sample.mvc.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import l.sy.randomCardBattle._sample.domain.entity.Sample;
import lombok.RequiredArgsConstructor;
import static l.sy.randomCardBattle._sample.domain.entity.QSample.sample;

import java.util.List;

@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepositoryCustom{
    private final JPAQueryFactory qf;

    @Override
    public List<Sample> sampleAll() {
        return qf.selectFrom(sample).fetch();
    }
}
