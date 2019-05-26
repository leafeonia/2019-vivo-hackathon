package advertisingspaceforrent.demo.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PuzzleMapper {

    List<Integer> selectPuzzleByUserid(@Param("userid") Integer userid);
}
