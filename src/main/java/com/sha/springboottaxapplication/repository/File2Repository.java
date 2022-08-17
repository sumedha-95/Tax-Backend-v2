package com.sha.springboottaxapplication.repository;

import com.sha.springboottaxapplication.model.File2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface File2Repository extends JpaRepository<File2,String> {

@Query(value = "select distinct date as id from file",nativeQuery = true)
List<File2> findByDate(String date);
}
