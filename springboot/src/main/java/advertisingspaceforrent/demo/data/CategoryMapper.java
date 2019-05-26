package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectCategoryByLanguage(@Param("getCategoryForm") Integer languageId);
}
