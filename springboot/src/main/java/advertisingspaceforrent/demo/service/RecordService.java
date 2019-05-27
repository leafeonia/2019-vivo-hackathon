package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface RecordService {

    ResponseVO getAllRecordsByUserId(Integer userId);

    ResponseVO addRecord(Integer userId, Integer questionId);

    ResponseVO delRecord(Integer userId, Integer questionId);

}
