package l.s.y.randomCardBattle._sample;


import l.sy.randomCardBattle._sample.domain.entity.Sample;
import l.sy.randomCardBattle._sample.domain.entity.SampleEnum;
import l.sy.randomCardBattle._sample.mvc.repository.SampleRepository;
import l.sy.randomCardBattle._sample.mvc.repository.SampleRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
//@Transactional
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
        Sample test1 = Sample.builder()
                .sampleName("hi im sample Name")
                .sampleEnum(SampleEnum.SAMPLE2)
                .build();
        Sample end = sampleRepository.save(test1);
        log.debug("end={}", end);
    }

    @Test
    public void qd(){
        log.debug("end={}", sampleRepositoryImpl.sampleAll());
    }
}
