package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.PuzzleService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PuzzleController {

    @Autowired
    private PuzzleService puzzleService;

    @RequestMapping("/puzzle/get")
    public ResponseVO getPuzzle(@RequestParam("userid") Integer userid){
        return puzzleService.getPuzzle(userid);
    }
}
