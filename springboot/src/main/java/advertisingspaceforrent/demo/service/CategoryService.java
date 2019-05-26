package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.ResponseVO;

public interface CategoryService {
    /**
     * 获取类别
     * @param languageId 请求类别表单(语言Id)
     * @return Category List 类别表单(id、名称、语言)
     */
    ResponseVO getCategory(Integer languageId);
}
