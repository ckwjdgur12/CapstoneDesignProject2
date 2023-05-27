package kr.ac.knu.CapstoneDesignProject2.service.Interfaces;

import kr.ac.knu.CapstoneDesignProject2.dto.CategoryDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(int theId);

    Category save(Category theCategory);

    void deleteById(int theId);

    CategoryDTO getCategoryWithChatRoomCount(int categoryId);

    List<CategoryDTO> getAllCategoriesWithChatRoomCount();

}
