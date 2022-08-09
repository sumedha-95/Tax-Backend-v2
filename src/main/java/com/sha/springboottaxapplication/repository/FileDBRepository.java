package com.sha.springboottaxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sha.springboottaxapplication.model.File;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<File,Long> {



    @Query(value = "select * from File where user_id =?1", nativeQuery = true)
    List<File> findByFileID(String userId);

}
