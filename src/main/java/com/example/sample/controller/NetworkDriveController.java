package com.example.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.dto.DriveDto;
import com.example.sample.service.DriveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/networkDrive")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NetworkDriveController {
	
	private final DriveService driveService;
	
	@GetMapping
	public List<DriveDto> getAllDrives() {
		return driveService.getAllDrives();
	}
	
	@PostMapping
	public DriveDto addDrive(@RequestBody DriveDto driveDto) {
		return driveService.addDrive(driveDto);
	}
	
	@PutMapping
	public DriveDto updateDrive(@RequestBody DriveDto driveDto) {
		return driveService.updateDrive(driveDto);
	}
	
	@PutMapping("/connect")
	public DriveDto connectDrive(@RequestBody DriveDto driveDto) {
		return driveService.connect(driveDto);
	}
	
	@DeleteMapping("/{driveId}")
	public void deleteDrive(@PathVariable int driveId) {
		driveService.deletDrive(driveId);
	}
	

}
