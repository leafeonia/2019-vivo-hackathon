package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.GetQuestionForm;
import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.ResponseVO;

public interface QuestionService {

    /**
     * 获取指定语言、类别的题目
     * @param getQuestionForm 请求题目表单(语言、类别)
     * @return QuestionForm 题目表单(id、内容、选项、正确答案、语言、类别)
     */
    ResponseVO getQuestion(GetQuestionForm getQuestionForm);

    ResponseVO insertQuestion(InsertQuestionForm insertQuestionForm);
}
