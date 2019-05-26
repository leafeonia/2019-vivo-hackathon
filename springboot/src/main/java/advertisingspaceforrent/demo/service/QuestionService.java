package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.ResponseVO;

public interface QuestionService {

    /**
     * 获取指定语言、类别的题目
     * @param categoryId 请求题目表单(类别Id)
     * @return Question List 题目表单(id、内容、选项、正确答案、类别)
     */
    ResponseVO getQuestion(Integer categoryId);

    /**
     * 插入题目
     * @param insertQuestionForm 插入题目表单(内容、选项、正确答案、类别)
     * @return None
     */
    ResponseVO insertQuestion(InsertQuestionForm insertQuestionForm);
}
