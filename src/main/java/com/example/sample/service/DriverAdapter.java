package com.example.sample.service;

import com.example.sample.constants.ConnectionStatus;
import com.example.sample.dto.DriveDto;
import com.example.sample.entity.Drive;

public class DriverAdapter {
	
	public static DriveDto convertToDriveDto(Drive drive) {
		return DriveDto.builder()
				.id(drive.getId())
				.serverName(drive.getServerName())
				.driveName(drive.getDriveName())
				.path(drive.getPath())
				.connectionStatus(drive.getConnectionStatus())
				.createdAt(drive.getCreatedAt())
				.build();
	}
	
	public static Drive convertToDriveEntity(DriveDto driveDto) {
		return Drive.builder()
				.id(driveDto.getId())
				.driveName(driveDto.getDriveName())
				.serverName(driveDto.getServerName())
				.path(driveDto.getPath())
				.connectionStatus(driveDto.getConnectionStatus()!=null?driveDto.getConnectionStatus():ConnectionStatus.DISCONNECTED)
				.build();
	}

}
