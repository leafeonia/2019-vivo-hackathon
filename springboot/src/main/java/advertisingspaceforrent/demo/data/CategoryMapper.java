package advertisingspaceforrent.demo.data;

import advertisingspaceforrent.demo.po.Category;
import advertisingspaceforrent.demo.po.Donelist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> selectCategoryByLanguage(@Param("languageId") Integer languageId);

    Donelist selectDonelistByUserAndCategoryId(@Param("categoryId") Integer categoryId,
                                               @Param("userId") Integer userId);

    int insertDonelist(@Param("userId") Integer userId,
                       @Param("categoryId") Integer categoryId);
}
