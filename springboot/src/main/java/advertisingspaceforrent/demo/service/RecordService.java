package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface RecordService {

    /**
     * 获取该用户全部记录
     * @param userId : 用户Id
     * @return 题目List
     */
    ResponseVO getAllRecordsByUserId(Integer userId);

    /**
     * 增加记录
     * @param userId : 用户Id
     * @param questionId : 问题Id
     * @return None
     */
    ResponseVO addRecord(Integer userId, Integer questionId);

    /**
     * 删除记录
     * @param userId : 用户Id
     * @param questionId : 问题Id
     * @return None
     */
    ResponseVO delRecord(Integer userId, Integer questionId);

}
