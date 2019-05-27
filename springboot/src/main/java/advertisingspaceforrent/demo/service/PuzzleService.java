package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface PuzzleService {

    /**
     * 获取图鉴
     * @param
     * userid : 用户Id
     * @return PuzzleId List
     */
    ResponseVO getPuzzle(Integer userid);

    /**
     * 增加图鉴
     * @param userid : 用户Id
     * @return None
     */
    ResponseVO addPuzzle(Integer userid);
}
