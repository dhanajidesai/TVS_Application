package com.example.tvs.controller;

import java.util.List;
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
import com.example.tvs.entity.PoliceStation;
import com.example.tvs.entity.User;
import com.example.tvs.entity.VehicalType;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.payload.ApiMsgResponse;
import com.example.tvs.service.PoliceStationService;
import com.example.tvs.service.UserService;
import com.example.tvs.service.VehicalTypeService;
import com.example.tvs.util.Constant;

@RestController
@RequestMapping("/policestation")
public class PoliceStationController {
	@Autowired
	PoliceStationService policeStationService;
	
	@RequestMapping(value = "/getAllPoliceStations", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PoliceStation> getAllPoliceStations() {
			return policeStationService.getAllPoliceStations();
	}

}
