package com.example.sample.service;

import java.util.List;

import com.example.sample.dto.DriveDto;

public interface DriveService {
	
	List<DriveDto> getAllDrives();
	
	DriveDto addDrive(DriveDto driveDto);
	
	DriveDto updateDrive(DriveDto driveDto);
	
	void deletDrive(int driveId);

	DriveDto connect(DriveDto driveDto);

}
