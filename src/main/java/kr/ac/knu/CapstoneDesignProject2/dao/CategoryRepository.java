package kr.ac.knu.CapstoneDesignProject2.dao;

import kr.ac.knu.CapstoneDesignProject2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT COUNT(cr) FROM Category c JOIN c.chatRooms cr WHERE c.id = :categoryId")
    int getChatRoomCountByCategoryId(@Param("categoryId") int categoryId);

    @Query("SELECT c.categoryId, c.categoryName, COUNT(cr) " +
            "FROM Category c LEFT JOIN c.chatRooms cr " +
            "GROUP BY c.categoryId, c.categoryName")
    List<Object[]> getAllCategoriesWithChatRoomCount();

}