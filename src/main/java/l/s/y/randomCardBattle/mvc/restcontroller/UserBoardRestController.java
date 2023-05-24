package l.s.y.randomCardBattle.mvc.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/board")
public class UserBoardRestController {

    @GetMapping("/sample")
    public ResponseEntity<String> sample(){
        return ResponseEntity.ok("sample");
    }
}
