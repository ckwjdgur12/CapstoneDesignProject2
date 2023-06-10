package kr.ac.knu.CapstoneDesignProject2.rest;

import kr.ac.knu.CapstoneDesignProject2.dto.response.CategoryDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler.MyNotFoundException;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategoriesWithChatRoomCount() {
        return categoryService.getAllCategoriesWithChatRoomCount();
    }

    @GetMapping("/categories/{categoryId}")
    public CategoryDTO getCategory(@PathVariable int categoryId) {

        Category theCategory = categoryService.findById(categoryId);

        if (theCategory == null) {
            throw new MyNotFoundException("Category id not found - " + categoryId);
        }

        return categoryService.getCategoryWithChatRoomCount(categoryId);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category theCategory){
        theCategory.setCategoryId(0);
        Category dbCategory = categoryService.save(theCategory);
        return dbCategory;
    }

    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category theCategory) {

        Category dbCategory = categoryService.save(theCategory);

        return dbCategory;
    }

    @DeleteMapping("/categories/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId) {

        Category tmpCategory = categoryService.findById(categoryId);

        if (tmpCategory == null) {
            throw new MyNotFoundException("Category id not found - " + categoryId);
        }

        categoryService.deleteById(categoryId);

        return "Deleted category Id - " + categoryId;
    }

}
