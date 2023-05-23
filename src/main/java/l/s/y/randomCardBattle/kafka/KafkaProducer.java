package l.s.y.randomCardBattle.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic myTopic1;

    @GetMapping("/publish/mytopic1")
    public String publishMyTopic1(){

        String message = "publish message to my topic_1" + UUID.randomUUID();
       kafkaTemplate.send(myTopic1.name(), message);
        log.debug("myTopicName : {}", myTopic1.name());
        return "done";
    }

}
