package com.quark.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quark.workshopmongo.domain.User;
import com.quark.workshopmongo.dto.UserDTO;
import com.quark.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository rep;

	public List<User> findAll() {
		return rep.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow();
	}

	public User insert(User obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObj = rep.findById(obj.getId());
		updateData(newObj.get(), obj);
		return rep.save(newObj.get());
	}
	

	private void updateData(User newObj, User obj) {
		 newObj.setName(obj.getName());
		 newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
