package com.tds.category;

import com.tds.response.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/category")
public class CategoryController {
    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all-category")
    public ResponseObject<List<Category>> getAllCategory() {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", categoryService.getAll());
    }

    @GetMapping("/get-by-id")
    public ResponseObject<Category> getCategoryById(String categoryId) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", categoryService.getById(categoryId));
    }

    @GetMapping("/get-by-name")
    public ResponseObject<List<Category>> getCategoryByName(String categoryName) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", categoryService.getByName(categoryName));
    }

    @PostMapping("/create-category")
    public ResponseObject<Category> createCategory(@RequestBody @Valid Category category) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", categoryService.save(category));
    }

    @DeleteMapping("/delete-by-id")
    public ResponseObject<String> deleteCategoryById(String categoryId) {
        categoryService.delete(categoryId);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", categoryId);
    }
}
