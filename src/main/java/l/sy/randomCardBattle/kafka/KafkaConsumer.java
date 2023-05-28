package l.sy.randomCardBattle.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "my_topic_1", groupId = "group1")
    public void consumeMyTopic1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition){
        log.info("[consume message]: {} from partition: {}", message, partition);
    }
}
