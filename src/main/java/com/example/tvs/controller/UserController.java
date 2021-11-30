package com.example.tvs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.User;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.payload.ApiMsgResponse;
import com.example.tvs.service.UserService;
import com.example.tvs.util.Constant;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUserDetails", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiMsgResponse> addUserDetails(@RequestBody User user) throws UserAlreadyExistException {
		try {
			return ResponseEntity.ok(new ApiMsgResponse(HttpStatus.OK.value(), Constant.SUCCESS, userService.addUserDetails(user)));
		}catch(Exception e) {
			ApiMsgResponse apiMsgResponse = new ApiMsgResponse(HttpStatus.CONFLICT.value(), e.getMessage() , null);
			return new ResponseEntity<ApiMsgResponse>(apiMsgResponse, HttpStatus.CONFLICT);
		}
		
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiMsgResponse> userLogin(@RequestBody LoginRequestdto loginRequestDto) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(new ApiMsgResponse(HttpStatus.OK.value(), Constant.SUCCESS, userService.userLogin(loginRequestDto)));
		}catch(Exception e) {
			ApiMsgResponse apiMsgResponse = new ApiMsgResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage() , null);
			return new ResponseEntity<ApiMsgResponse>(apiMsgResponse, HttpStatus.UNAUTHORIZED);
		}
		
	}

}
