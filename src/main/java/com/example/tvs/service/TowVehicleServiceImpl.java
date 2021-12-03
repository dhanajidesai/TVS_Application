package com.example.tvs.service;

import com.example.tvs.dto.TowVehicleDto;
import com.example.tvs.entity.TowVehicle;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.repository.TowVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TowVehicleServiceImpl implements TowVehicleService {

    @Autowired
    TowVehicleRepository towVehicleRepository;

    @Override
    public TowVehicle save(TowVehicleDto towVehicleDto) {
        TowVehicle towVehicle = new TowVehicle(towVehicleDto.getVehicleNo(), towVehicleDto.getVehicleType(), towVehicleDto.getDescription(), towVehicleDto.getRoad(), towVehicleDto.getImage(), towVehicleDto.getStatus(), towVehicleDto.getTowedById(), new Date(), towVehicleDto.getLastUpdateById(),new Date());
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

}
