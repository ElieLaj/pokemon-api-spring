package com.example.pokemonapi.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category newCategory) {
        categoryRepository.findCategoryByName(newCategory.getName()).ifPresent(category -> {
            throw new IllegalStateException("Category with name " + newCategory.getName() + " already exists");
        });
        return categoryRepository.save(newCategory);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with id " + id + " not found"));
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Long id, String name) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category with id " + id + " not found"));

        if (name != null && !name.isEmpty() && !name.equals(category.getName())) {
            category.setName(name);
        }

        return categoryRepository.save(category);
    }
}
