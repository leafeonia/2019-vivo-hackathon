package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface CategoryService {
    /**
     * 获取类别
     * @param
     * languageId : 语言Id
     * @return Category List 类别表单(id、名称、语言)
     */
    ResponseVO getCategory(Integer languageId);

    /**
     * 完成类别
     * @param
     * categoryId : 类别Id
     * @return None
     */
    ResponseVO finishCategory(Integer categoryId);
}
