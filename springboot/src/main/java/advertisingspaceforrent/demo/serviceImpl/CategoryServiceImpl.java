package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.CategoryMapper;
import advertisingspaceforrent.demo.po.Category;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl {
    @Autowired
    private CategoryMapper categoryMapper;

    public ResponseVO getCategory(Integer languageId){
        try {
            List<Category> category = categoryMapper.selectCategoryByLanguage(languageId);
            if(null == category){
                return ResponseVO.buildFailure("类别获取失败!");
            }
            return ResponseVO.buildSuccess(category);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("类别获取失败!");
        }
    }
}