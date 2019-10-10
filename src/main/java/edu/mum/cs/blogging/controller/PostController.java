package edu.mum.cs.blogging.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.cs.blogging.model.Post;
import edu.mum.cs.blogging.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	@GetMapping("/post/list")
	public String listPost() {
		return "post/list";
	}
	
	@GetMapping("/post/create")
	public String createPost(Model model) {
		model.addAttribute("post", new Post());
		return "post/create";
	}
	
	@PostMapping("/post/save")
	public String savePost(@Valid @ModelAttribute("post")Post post, @RequestParam("image")MultipartFile image, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) { 
			model.addAttribute("errors", bindingResult.getAllErrors());
			System.out.println(bindingResult.getAllErrors()); 
			return "post/create";
		}
		postService.savePost(post);
		return "redirect:/post/list";
	}
}
