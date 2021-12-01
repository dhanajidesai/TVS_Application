package com.example.tvs.controller;

import com.example.tvs.dto.TowVehicleDto;
import com.example.tvs.entity.TowVehicle;
import com.example.tvs.entity.User;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.payload.ApiMsgResponse;
import com.example.tvs.service.TowVehicleService;
import com.example.tvs.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class TowVehicleController {

    @Autowired
    TowVehicleService towVehicleService;

    @RequestMapping(value = "/towVehicle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiMsgResponse> towVehicle(@RequestBody TowVehicleDto towVehicleDto) {
        return ResponseEntity.ok(new ApiMsgResponse(HttpStatus.OK.value(), Constant.SUCCESS, towVehicleService.save(towVehicleDto)));
    }

    @RequestMapping(value = "/towVehicle/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiMsgResponse> updateTowVehicle(@PathVariable("id") Long id, @RequestBody TowVehicleDto towVehicleDto) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(new ApiMsgResponse(HttpStatus.OK.value(), Constant.SUCCESS, towVehicleService.update(id, towVehicleDto)));

        } catch (Exception e) {
            ApiMsgResponse apiMsgResponse = new ApiMsgResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
            return new ResponseEntity<ApiMsgResponse>(apiMsgResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/towVehicle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiMsgResponse> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        try {
            return ResponseEntity.ok(new ApiMsgResponse(HttpStatus.OK.value(), Constant.SUCCESS, towVehicleService.findById(id)));
        } catch (Exception e) {
            ApiMsgResponse apiMsgResponse = new ApiMsgResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
            return new ResponseEntity<ApiMsgResponse>(apiMsgResponse, HttpStatus.NOT_FOUND);
        }
    }
}
