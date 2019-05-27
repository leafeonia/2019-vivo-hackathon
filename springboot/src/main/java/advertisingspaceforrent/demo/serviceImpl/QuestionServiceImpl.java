package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.QuestionMapper;
import advertisingspaceforrent.demo.po.Question;
import advertisingspaceforrent.demo.service.QuestionService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    public ResponseVO getQuestion(Integer categoryId){
        try {
            List<Question> question = questionMapper.selectQuestionByCategory(categoryId);
            if(null == question){
                return ResponseVO.buildFailure("题目获取失败!");
            }
            return ResponseVO.buildSuccess(question);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("获取题目失败!");
        }
    }

    public ResponseVO insertQuestion(String context, String choiceA, String choiceB, String choiceC, String choiceD, Integer correct, Integer categoryId){
        try {
            int success = questionMapper.insertQuestion(context, choiceA, choiceB, choiceC, choiceD, correct, categoryId);
            if(success == 0){
                return ResponseVO.buildFailure("插入题库失败!");
            }
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("插入题库失败!");
        }
    }
}
