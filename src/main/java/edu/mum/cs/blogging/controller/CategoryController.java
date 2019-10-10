package edu.mum.cs.blogging.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.cs.blogging.model.Category;
import edu.mum.cs.blogging.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService service;
	
	@GetMapping("/category/list")
	public String listCategory(Model model) {
		model.addAttribute("categories", service.getAllCategory());
		return "category/list";
	}
	
	@GetMapping("/category/create")
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category/create";
	}
	
	@PostMapping("/category/save")
	public String saveCategory(@Valid @ModelAttribute("category")Category category, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "category/create";
		}
		service.saveCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/category/delete/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")Long categoryId) {
		Category category = service.getCategoryById(categoryId);
		if(category != null) {
			service.deleteCategory(category);
		}
		return "redirect:/category/list";
	}
	
	@GetMapping("/category/edit/{categoryId}")
	public String editCategory(@PathVariable("categoryId")Long categoryId, Model model) {
		Category category = service.getCategoryById(categoryId);
		if(category != null) {
			model.addAttribute("category", category);
		}
		return "category/edit";
	}
	
	@PostMapping("/category/update")
	public String updateCategory(@ModelAttribute("category")Category category) {
		service.updateCategory(category);
		return "redirect:/category/list";
	}
}
