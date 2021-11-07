package com.example.sample.dto;

import java.sql.Timestamp;

import com.example.sample.constants.ConnectionStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DriveDto {
	
	private int id;
	private String driveName;
	private String serverName;
	private String path;
	private Timestamp createdAt;
	private ConnectionStatus connectionStatus;
}
