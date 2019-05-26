package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<Question> selectQuestionByCategory(@Param("categoryId") Integer categoryId);

    int insertQuestion(@Param("context")String context,
                       @Param("choiceA") String choiceA,
                       @Param("choiceB") String choiceB,
                       @Param("choiceC") String choiceC,
                       @Param("choiceD") String choiceD,
                       @Param("correct") Integer correct,
                       @Param("categoryId") Integer categoryId);
}
