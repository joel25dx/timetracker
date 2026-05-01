package com.timetracker.timetracker.services;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.insert(category);
    }

    public void deleteCategoryById(String id) {
        categoryRepository.deleteById(id);
    }

   public Category updateCategory(Category category) {
      Category existingCategory = categoryRepository.findById(category.getId()).orElseThrow();
      existingCategory.setName(category.getName());
      return categoryRepository.save(existingCategory);
   }
