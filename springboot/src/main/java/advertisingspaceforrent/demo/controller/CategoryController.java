package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.CategoryService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    public final static Logger logger = LoggerFactory.getLogger("***TEST***");

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/get/{languageId}/{userId}")
    public ResponseVO getCategory(@PathVariable("languageId") Integer languageId, @PathVariable("userId") Integer userId){
        logger.info("languageId="+languageId+",userId="+userId);
        return categoryService.getCategory(languageId,userId);
    }

    @RequestMapping("/category/finish")
    public ResponseVO finishCategory(@RequestParam("userId") Integer userId, @RequestParam("categoryId") Integer categoryId) {
        return categoryService.finishCategory(userId,categoryId);
    }
}
