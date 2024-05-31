package com.tds.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    public final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(String categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public List<Category> getByName(String categoryName) {
        return categoryRepository.getCategoryListByCategoryName(categoryName.toUpperCase());
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
