package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.Puzzle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PuzzleMapper {

    List<Integer> selectPuzzleByUserid(@Param("userid") Integer userid);

    Puzzle selectPuzzleByUseridAndPuzzle(@Param("userid") Integer userid,
                                         @Param("puzzleid") Integer puzzleid);

    int insertPuzzle(@Param("userid") Integer userid,
                     @Param("puzzleid") Integer puzzleid);
}
