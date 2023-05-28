package l.sy.randomCardBattle.wshandler;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WsMessage {
    private String type;

    @Setter
    private String sender;
    private String channelID;
//    private String receiver;
    private Object data;
    public void newConnect(){
        this.type = "new";
    }

    public void closeConnect(){
        this.type = "close";
    }

    @Builder
    public WsMessage(String sender, String channelID, Object data){
        this.sender = sender;
        this.channelID = channelID;
        this.data = data;
    }
}
