package advertisingspaceforrent.demo.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonelistMapper {

    List<Integer> selectDonelistByUserid(@Param("userid") Integer userid);
}
