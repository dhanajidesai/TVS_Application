package com.example.tvs.service;

import java.util.Optional;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.User;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;

public interface UserService {
	User addUserDetails(User user) throws UserAlreadyExistException;
	Optional<User> userLogin(LoginRequestdto loginRequestdto) throws ResourceNotFoundException;
}
