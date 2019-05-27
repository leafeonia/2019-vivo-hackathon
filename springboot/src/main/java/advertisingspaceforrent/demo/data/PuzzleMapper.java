package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.PuzzleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PuzzleMapper {

    List<Integer> selectPuzzleByUserid(@Param("userid") Integer userid);

    PuzzleUser selectPuzzleByUseridAndPuzzle(@Param("userid") Integer userid,
                                             @Param("puzzleid") Integer puzzleid);

    int insertPuzzle(@Param("userid") Integer userid,
                     @Param("puzzleid") Integer puzzleid);
}
