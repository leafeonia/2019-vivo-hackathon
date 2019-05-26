package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface CategoryService {
    /**
     * 获取类别
     * @param languageId : 语言Id
     * @param userId : 用户Id
     * @return Category List 类别表单(id、名称、语言)
     */
    ResponseVO getCategory(Integer languageId, Integer userId);

    /**
     * 标记类别已完成
     * @param userId : 用户Id
     * @param categoryId :类别Id
     * @return None
     */
    ResponseVO finishCategory(Integer userId, Integer categoryId);
}
