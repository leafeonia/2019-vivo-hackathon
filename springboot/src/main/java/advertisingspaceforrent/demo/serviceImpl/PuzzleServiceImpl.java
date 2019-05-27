package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.PuzzleMapper;
import advertisingspaceforrent.demo.po.PuzzleUser;
import advertisingspaceforrent.demo.service.PuzzleService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PuzzleServiceImpl implements PuzzleService {
    @Autowired
    private PuzzleMapper puzzleMapper;

    public ResponseVO getPuzzle(Integer userid){
        try {
            List<Integer> puzzle = puzzleMapper.selectPuzzleByUserid(userid);
            if(null == puzzle){
                return ResponseVO.buildFailure("图鉴获取失败!");
            }
            return ResponseVO.buildSuccess(puzzle);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("图鉴获取失败!");
        }
    }

    public ResponseVO addPuzzle(Integer userid){
        try {
            List<Integer> puzzle = puzzleMapper.selectPuzzleByUserid(userid);
            if (puzzle.size()==9){
                return ResponseVO.buildFailure("恭喜你已获得全部图片!");
            }
            Random rand = new Random();
            while (true){
                Integer puzzleid = rand.nextInt(9)+1;
                if(puzzle.indexOf(puzzleid)==-1){
                    int success = puzzleMapper.insertPuzzle(userid, puzzleid);
                    if(success == 0){
                        return ResponseVO.buildFailure("图鉴增加失败!");
                    }
                    return ResponseVO.buildSuccess();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("图鉴增加失败!");
        }
    }
}
