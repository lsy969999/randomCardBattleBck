package l.sy.randomCardBattle._sample.mvc.restcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/test")
public class SampleRestController {
    @GetMapping
    public ResponseEntity<String> sampleOne(){
        log.debug("sample hi");
        return ResponseEntity.ok("sampleOK");
    }
}
