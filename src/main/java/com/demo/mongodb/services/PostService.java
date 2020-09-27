package com.demo.mongodb.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mongodb.domain.Post;
import com.demo.mongodb.repository.PostRepository;
import com.demo.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Optional<Post> findById(String id) {
		Optional<Post> user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, java.util.Date min, java.util.Date max) {
		max = new Date(max.getTime() + 24 * 60 *60 * 1000);
		return repo.fullSearch(text, min, max);
	}
}
