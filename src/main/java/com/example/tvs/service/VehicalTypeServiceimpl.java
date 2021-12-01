package com.example.tvs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.User;
import com.example.tvs.entity.VehicalType;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.repository.UserRepository;
import com.example.tvs.repository.VehicalTypeRepository;

@Service
public class VehicalTypeServiceimpl implements VehicalTypeService {
	@Autowired
	VehicalTypeRepository vehicalTypeRepository;
	
	@Override
	public VehicalType addVehicalTypes(VehicalType vehicalType) {
		VehicalType savedVehicalType = vehicalTypeRepository.save(vehicalType);
			return savedVehicalType;
	}
	
	@Override
	public List<VehicalType> getAllVehicalTypes(){
		List<VehicalType> vehicalTypeList=vehicalTypeRepository.findAll();
		return vehicalTypeList;
	}
	
	
}
