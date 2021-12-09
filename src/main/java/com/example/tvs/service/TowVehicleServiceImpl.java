package com.example.tvs.service;

import com.example.tvs.dto.TowVehicleDto;
import com.example.tvs.entity.TowVehicle;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.repository.TowVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TowVehicleServiceImpl implements TowVehicleService {

    @Autowired
    TowVehicleRepository towVehicleRepository;

    @Override
    public TowVehicle save(TowVehicleDto towVehicleDto) {
        TowVehicle towVehicle = new TowVehicle(towVehicleDto.getVehicleNo(), towVehicleDto.getVehicleType(), towVehicleDto.getDescription(), towVehicleDto.getRoad(), towVehicleDto.getImage(), towVehicleDto.getStatus(), towVehicleDto.getTowedById(), new Date(), towVehicleDto.getLastUpdateById(),new Date(),towVehicleDto.getPoliceStation());
        return towVehicleRepository.save(towVehicle);
    }

    @Override
    public TowVehicle update(Long id, TowVehicleDto towVehicleDto) throws ResourceNotFoundException {
        TowVehicle towVehicle  = towVehicleRepository.findTowVehicleById(id);
        if (towVehicle == null) {
            throw new ResourceNotFoundException("Vehicle not exist with id : "+id);
        }
        towVehicle.setVehicleNo(towVehicleDto.getVehicleNo());
        towVehicle.setVehicleType(towVehicleDto.getVehicleType());
        towVehicle.setDescription(towVehicleDto.getDescription());
        towVehicle.setRoad(towVehicleDto.getRoad());
        towVehicle.setImage(towVehicleDto.getImage());
        towVehicle.setStatus(towVehicleDto.getStatus());
        towVehicle.setTowedById(towVehicleDto.getTowedById());
        towVehicle.setUpdatedDate(new Date());
        towVehicle.setLastUpdateById(towVehicleDto.getLastUpdateById());
        towVehicle.setPoliceStation(towVehicleDto.getPoliceStation());
        return towVehicleRepository.save(towVehicle);
    }

    @Override
    public Optional<TowVehicle> findById(Long id) throws ResourceNotFoundException {
        TowVehicle towVehicle  = towVehicleRepository.findTowVehicleById(id);
        if (towVehicle == null) {
            throw new ResourceNotFoundException("Vehicle not exist with id : "+id);
        }
        return towVehicleRepository.findById(id);
    }
    
    @Override
    public List<TowVehicle> findByStatus(String status) throws ResourceNotFoundException {
    	if(status.equalsIgnoreCase("NULL")) {
    		List<TowVehicle> towVehicleList  = towVehicleRepository.findTowVehicle(status);
    		if (towVehicleList.isEmpty()) {
                throw new ResourceNotFoundException("Towed vehicle is not exist in Database");
            }
            return towVehicleList;
    	}else {
    		List<TowVehicle> towVehicleList  = towVehicleRepository.findTowVehicleBystatus(status);
            if (towVehicleList.isEmpty()) {
                throw new ResourceNotFoundException("Vehicle not exist with status : "+status);
            }
            return towVehicleList;
    	}
        
    }
    
    @Override
    public Optional<TowVehicle> findByVehicleNo(String vehicleNo) throws ResourceNotFoundException {
    	Optional<TowVehicle> towVehicle  = towVehicleRepository.findByVehicleNo(vehicleNo);
        if (!towVehicle.isPresent()) {
            throw new ResourceNotFoundException("Vehicle not exist with vehicleNo : "+vehicleNo);
        }else {
        	return towVehicle;
        }
        
    }
    
    
    @Override
    public List<TowVehicle> findByStatusAndPoliceStation(String status,String policestation) throws ResourceNotFoundException {
    	if(status.equalsIgnoreCase("NULL")) {
    		if(policestation.equalsIgnoreCase("NULL")) {
    			List<TowVehicle> towVehicleList  = towVehicleRepository.findAll();
        		if (towVehicleList.isEmpty()) {
                    throw new ResourceNotFoundException("Towed vehicle is not exist in Database");
                }
                return towVehicleList;
    		}else {
    			List<TowVehicle> towVehicleList  = towVehicleRepository.findTowVehicleByPoliceStation(policestation);
        		if (towVehicleList.isEmpty()) {
                    throw new ResourceNotFoundException("Towed vehicle is not exis with Police station :"+policestation);
                }
                return towVehicleList;
    		}
    		
    	}else {
    		if(policestation.equalsIgnoreCase("NULL")) {
    			List<TowVehicle> towVehicleList  = towVehicleRepository.findTowVehicleBystatus(status);
                if (towVehicleList.isEmpty()) {
                    throw new ResourceNotFoundException("Vehicle not exist with status : "+status);
                }
                return towVehicleList;
    		}else {
    			List<TowVehicle> towVehicleList  = towVehicleRepository.findTowVehicleBystatusAndPoliceStation(status,policestation);
                if (towVehicleList.isEmpty()) {
                    throw new ResourceNotFoundException("Vehicle not exist with status : "+status +" and PoliceStation :" +policestation);
                }
                return towVehicleList;
    		}
    		
    	}
        
    }

}
