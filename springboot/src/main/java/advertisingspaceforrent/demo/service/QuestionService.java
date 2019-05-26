package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.ResponseVO;

public interface QuestionService {

    /**
     * 获取指定语言、类别的题目
     * @param categoryId 请求题目表单(类别Id)
     * @return QuestionForm 题目表单(id、内容、选项、正确答案、语言、类别)
     */
    ResponseVO getQuestion(Integer categoryId);

    ResponseVO insertQuestion(InsertQuestionForm insertQuestionForm);
}
