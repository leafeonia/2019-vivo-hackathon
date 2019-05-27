package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.CategoryService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/get")
    public ResponseVO getCategory(@RequestParam("languageId") Integer languageId, @RequestParam("userId") Integer userId){
        return categoryService.getCategory(languageId,userId);
    }

    @RequestMapping("/category/finish")
    public ResponseVO finishCategory(@RequestParam("userId") Integer userId, @RequestParam("categoryId") Integer categoryId) {
        return categoryService.finishCategory(userId,categoryId);
    }
}
