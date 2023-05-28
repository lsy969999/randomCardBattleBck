package l.sy.randomCardBattle.wshandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        String sessionId = session.getId();
        sessions.remove(sessionId);

        WsMessage wsMessage = WsMessage.builder()
                .sender(sessionId)
                .build();
        wsMessage.closeConnect();
        sessions.values().forEach(s -> {
            try {
                s.sendMessage(new TextMessage(wsMessage.toString()));
            } catch (IOException e){
                log.error("after connect close {}", e.getMessage());
            }
        });
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        String sessionId = session.getId();
        sessions.put(sessionId, session);

        WsMessage wsMessage = WsMessage.builder()
                .sender(sessionId)
//                .receiver("all")
                .build();
        wsMessage.newConnect();

        sessions.values().forEach(s->{
            try{
                if(!s.getId().equals(sessionId)){
                    s.sendMessage(new TextMessage(wsMessage.toString()));
                }
            } catch (IOException e){
                log.error("send Exception: {}", e.getMessage());
            }
        });
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
    }
}
