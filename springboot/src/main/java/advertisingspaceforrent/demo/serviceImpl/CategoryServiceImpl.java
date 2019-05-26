package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.CategoryMapper;
import advertisingspaceforrent.demo.po.Category;
import advertisingspaceforrent.demo.service.CategoryService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
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

    public ResponseVO finishCategory(Integer categoryId){
        try {
            int success = categoryMapper.finishCategoryById(categoryId);
            if(success==0){
                return ResponseVO.buildFailure("类别完成失败!");
            }
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("类别完成失败!");
        }
    }
}
