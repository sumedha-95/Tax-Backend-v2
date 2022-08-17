package com.sha.springboottaxapplication.repository;

import com.sha.springboottaxapplication.model.File1;
import com.sha.springboottaxapplication.model.File2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<File1,Long> {



    @Query(value = "select * from File where user_id =?1", nativeQuery = true)
    List<File1> findByFileID(String userId);


//    @Query(value = "select distinct date,all from file",nativeQuery = true)
//    List<File1> findByDate(String date);

}
