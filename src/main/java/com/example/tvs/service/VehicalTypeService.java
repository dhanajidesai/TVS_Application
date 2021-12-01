package com.example.tvs.service;

import java.util.List;
import java.util.Optional;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.User;
import com.example.tvs.entity.VehicalType;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;

public interface VehicalTypeService {
	
	VehicalType addVehicalTypes(VehicalType vehicalType);
	List<VehicalType> getAllVehicalTypes();
}
