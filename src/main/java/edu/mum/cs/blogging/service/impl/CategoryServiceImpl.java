package edu.mum.cs.blogging.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.blogging.model.Category;
import edu.mum.cs.blogging.repository.CategoryRepository;
import edu.mum.cs.blogging.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository repository;
	
	@Override
	public List<Category> getAllCategory() {
		return repository.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		return repository.save(category);
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return repository.getOne(categoryId);
	}

	@Override
	public void deleteCategory(Category category) {
		repository.delete(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return repository.save(category);
	}

}
