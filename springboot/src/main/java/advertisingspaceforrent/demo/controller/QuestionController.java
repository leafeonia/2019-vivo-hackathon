package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.QuestionService;
import advertisingspaceforrent.demo.vo.InsertQuestionForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("question/get")
    public ResponseVO getQuestion(@RequestParam("categoryId") Integer categoryId){
        return questionService.getQuestion(categoryId);
    }

    @RequestMapping("question/insert")
    public ResponseVO insertQuestion(@RequestBody InsertQuestionForm insertQuestionForm){
        return questionService.insertQuestion(insertQuestionForm);
    }
}
