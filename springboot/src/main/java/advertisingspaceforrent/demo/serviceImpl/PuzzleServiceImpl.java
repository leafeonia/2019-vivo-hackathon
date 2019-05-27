package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.PuzzleMapper;
import advertisingspaceforrent.demo.po.PuzzleUser;
import advertisingspaceforrent.demo.service.PuzzleService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResponseVO addPuzzle(Integer userid, Integer puzzleid){
        try {
            PuzzleUser puzzle = puzzleMapper.selectPuzzleByUseridAndPuzzle(userid, puzzleid);
            if(null != puzzle){
                return ResponseVO.buildFailure("该图鉴已获得!");
            }

            int success = puzzleMapper.insertPuzzle(userid, puzzleid);
            if(success == 0){
                return ResponseVO.buildFailure("图鉴增加失败!");
            }
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("图鉴增加失败!");
        }
    }
}
