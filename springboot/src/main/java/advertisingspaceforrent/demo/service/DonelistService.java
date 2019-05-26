package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface DonelistService {

    /**
     * 获取已做题
     * @param userid : 用户名称
     * @return CategoryId List
     */
    ResponseVO getDonelist(Integer userid);
}
