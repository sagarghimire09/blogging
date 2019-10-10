package edu.mum.cs.blogging.service;

import edu.mum.cs.blogging.model.User;

public interface UserService {
	User saveUser(User user);
	User findByUseraname(String username);
}
