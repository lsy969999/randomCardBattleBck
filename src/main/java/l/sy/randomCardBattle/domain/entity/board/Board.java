package l.sy.randomCardBattle.domain.entity.board;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class Board {
    private Long boardSn;


    @Lob
    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TYPE")
    private BoardType boardType;

    @Column(name = "STATUS")
    private BoardStatus boardStatus;



}
