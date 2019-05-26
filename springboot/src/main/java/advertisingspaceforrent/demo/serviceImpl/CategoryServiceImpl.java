package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.CategoryMapper;
import advertisingspaceforrent.demo.po.Category;
import advertisingspaceforrent.demo.service.CategoryService;
import advertisingspaceforrent.demo.vo.CategoryVO;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;

    public ResponseVO getCategory(Integer languageId, Integer userId){
        try {
            List<Category> category = categoryMapper.selectCategoryByLanguage(languageId);
            List<CategoryVO> res = new ArrayList<>();
            for (Category ca : category) {
                CategoryVO vo = new CategoryVO();
                vo.setId(ca.getId());
                vo.setName(ca.getName());
                vo.setLanguageId(ca.getLanguageId());
                if (categoryMapper.selectDonelistByUserAndCategoryId(ca.getId(),userId) == null) {
                    vo.setFinish(false);
                } else {
                    vo.setFinish(true);
                }
                res.add(vo);
            }
            if(null == category){
                return ResponseVO.buildFailure("类别获取失败!");
            }
            return ResponseVO.buildSuccess(res);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("类别获取失败!");
        }
    }

    @Override
    public ResponseVO finishCategory(Integer userId, Integer categoryId) {
        try {
            if (categoryMapper.insertDonelist(userId,categoryId) == 1) {
                return ResponseVO.buildSuccess();
            } else {
                return ResponseVO.buildFailure("完成类别失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("完成类别失败!");
        }
    }
}
