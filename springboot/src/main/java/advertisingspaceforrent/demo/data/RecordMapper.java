package advertisingspaceforrent.demo.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {

    List<Integer> selectRecordsByUserId(@Param("userId") Integer userId);

    int insertRecord(@Param("userId") Integer userId,
                     @Param("questionId") Integer questionId);

    int deleteRecord(@Param("userId") Integer userId,
                     @Param("questionId") Integer questionId);

    Integer selectRecord(@Param("userId") Integer userId,
                         @Param("questionId") Integer questionId);

}
