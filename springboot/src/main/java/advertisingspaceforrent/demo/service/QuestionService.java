package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.ResponseVO;

public interface QuestionService {

    /**
     * 获取题目
     * @param
     * categoryId : 类别Id
     * @return Question List
     */
    ResponseVO getQuestion(Integer categoryId);

    /**
     * 插入题目
     * @param
     * context : 内容
     * choiceA : A选项
     * choiceB : B选项
     * choiceC : C选项
     * choiceD : D选项
     * correct : 正确答案
     * categoryId : 类别Id
     * @return None
     */
    ResponseVO insertQuestion(
            String context,
            String choiceA,
            String choiceB,
            String choiceC,
            String choiceD,
            Integer correct,
            Integer categoryId);
}
