package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.QuestionMapper;
import advertisingspaceforrent.demo.data.RecordMapper;
import advertisingspaceforrent.demo.po.Question;
import advertisingspaceforrent.demo.service.RecordService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordMapper recordMapper;
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public ResponseVO getAllRecordsByUserId(Integer userId) {
        try {
            List<Integer> records = recordMapper.selectRecordsByUserId(userId);
            List<Question> res = new ArrayList<>();
            for (Integer id : records) {
                res.add(questionMapper.selectQuestionById(id));
            }
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("获取错题失败!");
        }
    }

    @Override
    public ResponseVO addRecord(Integer userId, Integer questionId) {
        try {
            Integer i = recordMapper.selectRecord(userId,questionId);
            if (i == null) {
                if (recordMapper.insertRecord(userId, questionId) == 1) {
                    return ResponseVO.buildSuccess();
                } else {
                    return ResponseVO.buildFailure("添加错题失败!");
                }
            } else {
                return ResponseVO.buildFailure("已在错题集中");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("添加错题失败!");
        }
    }

    @Override
    public ResponseVO delRecord(Integer userId, Integer questionId) {
        try {
            if (recordMapper.deleteRecord(userId,questionId) == 1) {
                return ResponseVO.buildSuccess();
            } else {
                return ResponseVO.buildFailure("删除错题失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("删除错题失败!");
        }
    }
}
