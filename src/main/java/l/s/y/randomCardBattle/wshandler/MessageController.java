package l.s.y.randomCardBattle.wshandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
