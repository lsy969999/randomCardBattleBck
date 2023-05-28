package l.sy.randomCardBattle.wshandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Slf4j
@Controller
public class MessageController {

//    private final SimpleMessageSen
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/hello")
    public void message(WsMessage wsMessage){
        log.debug(">>{}", wsMessage);
        simpMessageSendingOperations.convertAndSend("/sub/channel/" + wsMessage.getChannelID(), wsMessage);
    }
}
