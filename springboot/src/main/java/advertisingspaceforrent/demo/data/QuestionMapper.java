package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.Question;
import advertisingspaceforrent.demo.vo.GetQuestionForm;
import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.QuestionForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Question> selectQuestionByLanguageAndCategory(@Param("getQuestionForm") GetQuestionForm getQuestionForm);
    int insertQuestion(@Param("InsertQuestionForm")InsertQuestionForm insertQuestionForm);
}
