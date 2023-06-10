package kr.ac.knu.CapstoneDesignProject2.service.Implements;

import kr.ac.knu.CapstoneDesignProject2.dao.CategoryRepository;
import kr.ac.knu.CapstoneDesignProject2.dto.response.CategoryDTO;
import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import kr.ac.knu.CapstoneDesignProject2.service.Interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryDTO> getAllCategoriesWithChatRoomCount() {
        List<Object[]> results = categoryRepository.getAllCategoriesWithChatRoomCount();

        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Object[] result : results) {
            int categoryId = ((Number) result[0]).intValue();
            String categoryName = (String) result[1];
            int chatRoomCount = ((Number) result[2]).intValue();

            CategoryDTO categoryDTO = new CategoryDTO(categoryId, categoryName, chatRoomCount);
            categoryDTOs.add(categoryDTO);
        }

        return categoryDTOs;
    }

    @Override
    public Category findById(int theId) {

        Optional<Category> result = categoryRepository.findById(theId);

        Category theCategory = null;

        if (result.isPresent()) {
            theCategory = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find category id - " + theId);
        }

        return theCategory;

    }

    @Override
    public Category save(Category theCategory) {
        return categoryRepository.save(theCategory);
    }

    @Override
    public void deleteById(int theId) {
        categoryRepository.deleteById(theId);
    }

    @Override
    public CategoryDTO getCategoryWithChatRoomCount(int categoryId) {
        Optional<Category> result = categoryRepository.findById(categoryId);

        Category theCategory = null;

        if (result.isPresent()) {
            theCategory = result.get();
        } else {
            // we didn't find the user
            throw new RuntimeException("Did not find category id - " + categoryId);
        }
        int chatRoomCount = categoryRepository.getChatRoomCountByCategoryId(categoryId);
        return new CategoryDTO(theCategory.getCategoryId(), theCategory.getCategoryName(), chatRoomCount);
    }

}
