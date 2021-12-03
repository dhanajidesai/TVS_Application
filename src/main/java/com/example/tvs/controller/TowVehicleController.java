package com.example.tvs.controller;

import com.example.tvs.dto.TowVehicleDto;
import com.example.tvs.entity.TowVehicle;
import com.example.tvs.entity.User;
import com.example.tvs.exception.ResourceNotFoundException;
import com.example.tvs.exception.UserAlreadyExistException;
import com.example.tvs.payload.ApiMsgResponse;
import com.example.tvs.service.TowVehicleService;
import com.example.tvs.util.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/vehicle")
public class TowVehicleController {
	
	@Value("${uploadedImagesPath}")
	private String filePath;

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
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiMsgResponse> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    	Date date=new Date();
    	Long ldate=date.getTime();
    	String name = file.getOriginalFilename();
    	int dot = name.lastIndexOf('.');
    	String base = (dot == -1) ? name : name.substring(0, dot);
    	String extension = (dot == -1) ? "" : name.substring(dot+1);
    	File convertFile=new File(filePath+base+"_"+ldate+"."+extension);
    	String uploadedImage=base+"_"+ldate+"."+extension;
    	convertFile.createNewFile();
    	FileOutputStream fout=new FileOutputStream(convertFile);
    	fout.write(file.getBytes());
    	fout.close();
    	return ResponseEntity.ok(new ApiMsgResponse(HttpStatus.OK.value(), Constant.SUCCESS,uploadedImage));
    }
    
}
