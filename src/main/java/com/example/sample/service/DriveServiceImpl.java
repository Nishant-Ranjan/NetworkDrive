package com.example.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sample.constants.ConnectionStatus;
import com.example.sample.dto.DriveDto;
import com.example.sample.entity.Drive;
import com.example.sample.exception.ConnectionNotFoundException;
import com.example.sample.exception.RecordNotFoundException;
import com.example.sample.repository.DriveRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriveServiceImpl implements DriveService{
	
	private final DriveRepository driveRepo;
	
	@Override
	public DriveDto connect(DriveDto driveDto) {
		int tmp = new Random().nextInt(11);
		log.info("Next Num: "+ tmp);
		if(tmp % 2 == 0) {
			driveDto.setConnectionStatus(ConnectionStatus.CONNECTED);
			return updateDrive(driveDto);
		}
		driveDto.setConnectionStatus(ConnectionStatus.DISCONNECTED);
		updateDrive(driveDto);
		throw new ConnectionNotFoundException("Unable to connect to drive: "+ driveDto.getDriveName());
	}

	@Override
	public List<DriveDto> getAllDrives() {
		List<Drive> drive = driveRepo.findAll();
		return drive.stream()
				.map(record -> DriverAdapter.convertToDriveDto(record))
				.collect(Collectors.toList());
	}

	@Override
	public DriveDto addDrive(DriveDto driveDto) {
		return DriverAdapter.convertToDriveDto(driveRepo.save(DriverAdapter.convertToDriveEntity(driveDto)));
	}

	@Override
	public DriveDto updateDrive(DriveDto driveDto) {
		Optional<Drive> driveOptional = driveRepo.findById(driveDto.getId());
		if(driveOptional.isEmpty()) {
			throw new RecordNotFoundException("Unable to update as no Drives found with name : "+ driveDto.getDriveName());
		}
		return DriverAdapter.convertToDriveDto(driveRepo.save(DriverAdapter.convertToDriveEntity(driveDto)));
	}

	@Override
	public void deletDrive(int driveId) {
		Optional<Drive> driveOptional = driveRepo.findById(driveId);
		if(driveOptional.isEmpty()) {
			throw new RecordNotFoundException("Unable to delete as no Drives found with id : "+ driveId);
		}
		
		driveRepo.delete(driveOptional.get());
	}

}
