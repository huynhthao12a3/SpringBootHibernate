package com.tds.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, String> {
    @Query(value = "select * from category where upper(category_name) like %:keyword% ", nativeQuery = true)
    public List<Category> getCategoryListByCategoryName(@Param("keyword") String keyword);
}
