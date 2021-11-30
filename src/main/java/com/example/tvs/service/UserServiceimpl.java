package com.example.tvs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.User;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.repository.UserRepository;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUserDetails(User user) throws UserAlreadyExistException {
		User existingUser = userRepository.findByEmailId(user.getEmailId());
		if(existingUser!=null) {
			throw new UserAlreadyExistException("User Already Exist with this Email");
		}else {
			User savedUser = userRepository.save(user);
			return savedUser;
		}
		
	}
	
	@Override
	public Optional<User> userLogin(LoginRequestdto loginRequestdto) throws ResourceNotFoundException {
		List<User> users=userRepository.getUserByEmailIdandPassword(loginRequestdto.getEmailId(),loginRequestdto.getPassword());
		if(users.isEmpty()) {
			throw new ResourceNotFoundException("Invalid UserName and Password");
		}else {
			return Optional.of(users.get(0));
		}
	}
	
	
}
