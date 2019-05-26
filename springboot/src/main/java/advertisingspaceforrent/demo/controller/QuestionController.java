package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.QuestionService;
import advertisingspaceforrent.demo.vo.GetQuestionForm;
import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping
    public ResponseVO getQuestion(@RequestBody GetQuestionForm getQuestionForm){
        return questionService.getQuestion(getQuestionForm);
    }

    public ResponseVO insertQuestion(@RequestBody InsertQuestionForm insertQuestionForm){
        return questionService.insertQuestion(insertQuestionForm);
    }
}
