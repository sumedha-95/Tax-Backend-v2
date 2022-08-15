package com.sha.springboottaxapplication.repository;

import com.sha.springboottaxapplication.model.FileUpload;
import com.sha.springboottaxapplication.repository.projection.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileUploadRepository extends JpaRepository<FileUpload,Long> {

    @Query("select " +
    "file.name as name,upload.url as url,upload.uploadTime as uploadTime "+
            "from FileUpload upload left join File1 file on file.id = upload.fileId "+
            "where upload.userId = :userId")
    List<FileItem> findAllUploadsFilebyUser(@Param("userId")Long userId);

}
