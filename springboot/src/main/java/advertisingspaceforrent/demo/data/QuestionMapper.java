package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.Question;
import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Question> selectQuestionByCategory(@Param("categoryId") Integer categoryId);
    int insertQuestion(@Param("InsertQuestionForm")InsertQuestionForm insertQuestionForm);
}
