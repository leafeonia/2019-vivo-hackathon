package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.RecordService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping("/record/get")
    public ResponseVO getRecordsByUserId(@RequestParam("userId") Integer userId) {
        return recordService.getAllRecordsByUserId(userId);
    }

    @RequestMapping("/record/add")
    public ResponseVO addRecord(@RequestParam("userId") Integer userId, @RequestParam("questionId") Integer questionId) {
        return recordService.addRecord(userId,questionId);
    }

    @RequestMapping("/record/del")
    public ResponseVO delRecord(@RequestParam("userId") Integer userId, @RequestParam("questionId") Integer questionId) {
        return recordService.delRecord(userId,questionId);
    }
}
