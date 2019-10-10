package edu.mum.cs.blogging.service;

import java.util.List;

import edu.mum.cs.blogging.model.Post;

public interface PostService {
	List<Post> getAllPost();
	Post savePost(Post post);
	Post getPostById(Long postId);
	void deletePost(Post post);
	Post updatePost(Post post);
}
