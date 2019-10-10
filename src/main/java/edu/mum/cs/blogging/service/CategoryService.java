package edu.mum.cs.blogging.service;

import java.util.List;

import edu.mum.cs.blogging.model.Category;

public interface CategoryService {
	List<Category> getAllCategory();
	Category saveCategory(Category category);
	Category getCategoryById(Long categoryId);
	void deleteCategory(Category category);
	Category updateCategory(Category category);
}
