package com.quark.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.workshopmongo.domain.User;
import com.quark.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;

	public List<User> findAll(){
		return rep.findAll();
	}
}
