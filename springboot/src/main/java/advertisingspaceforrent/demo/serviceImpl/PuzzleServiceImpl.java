package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.PuzzleMapper;
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
}
