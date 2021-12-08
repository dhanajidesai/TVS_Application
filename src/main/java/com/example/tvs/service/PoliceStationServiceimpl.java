package com.example.tvs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tvs.dto.LoginRequestdto;
import com.example.tvs.entity.PoliceStation;
import com.example.tvs.entity.User;
import com.example.tvs.entity.VehicalType;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.repository.UserRepository;
import com.example.tvs.repository.PoliceStationRepository;

@Service
public class PoliceStationServiceimpl implements PoliceStationService {
	@Autowired
	PoliceStationRepository policeStationRepository;
	
	@Override
	public List<PoliceStation> getAllPoliceStations(){
		List<PoliceStation> policeStationList=policeStationRepository.findAll();
		return policeStationList;
	}
	
	
}
