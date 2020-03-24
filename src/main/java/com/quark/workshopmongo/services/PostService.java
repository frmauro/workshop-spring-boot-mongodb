package com.quark.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.workshopmongo.domain.Post;
import com.quark.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository rep;

	public Post findById(String id) {
		Optional<Post> obj = rep.findById(id);
		return obj.orElseThrow();
	}
	
	public List<Post> findByTitle(String text){
		return rep.searchTitle(text);
	}

}
