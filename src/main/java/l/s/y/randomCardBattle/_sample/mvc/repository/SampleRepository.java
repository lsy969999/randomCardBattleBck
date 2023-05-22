package l.s.y.randomCardBattle._sample.mvc.repository;

import l.s.y.randomCardBattle._sample.domain.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long>, SampleRepositoryCustom {
}
