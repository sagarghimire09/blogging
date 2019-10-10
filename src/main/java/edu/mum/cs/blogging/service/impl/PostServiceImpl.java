package edu.mum.cs.blogging.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.blogging.model.Post;
import edu.mum.cs.blogging.repository.PostRepository;
import edu.mum.cs.blogging.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository repository;
	
	@Override
	public List<Post> getAllPost() {
		return repository.findAll();
	}

	@Override
	public Post savePost(Post post) {
		return repository.save(post);
	}

	@Override
	public Post getPostById(Long postId) {
		return repository.getOne(postId);
	}

	@Override
	public void deletePost(Post post) {
		repository.delete(post);
	}

	@Override
	public Post updatePost(Post post) {
		return repository.save(post);
	}

}
