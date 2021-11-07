package com.example.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample.entity.Drive;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Integer> {

}
