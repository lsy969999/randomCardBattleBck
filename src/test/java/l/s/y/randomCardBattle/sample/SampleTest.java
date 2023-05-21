package l.s.y.randomCardBattle.sample;


import jakarta.transaction.Transactional;
import l.s.y.randomCardBattle.sample.domain.entity.QSample;
import l.s.y.randomCardBattle.sample.domain.entity.Sample;
import l.s.y.randomCardBattle.sample.mvc.repository.SampleRepository;
import l.s.y.randomCardBattle.sample.mvc.repository.SampleRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
public class SampleTest {

    @Autowired private SampleRepository sampleRepository;
    @Autowired private SampleRepositoryImpl sampleRepositoryImpl;

    @Test
    public void test(){
        log.debug("hi");
    }

    @Test
    public void getSamples(){
        List<Sample> sampleList = sampleRepository.findAll();
        log.debug("sampleList={}", sampleList);
    }

    @Test
    public void saveSample(){
        Sample test1 = Sample.builder().sampleName("hi im sample Name").build();
        Sample end = sampleRepository.save(test1);
        log.debug("end={}", end);
    }

    @Test
    public void qd(){
        log.debug("end={}", sampleRepositoryImpl.sampleAll());
    }
}
