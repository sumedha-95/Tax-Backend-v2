//package com.sha.springboottaxapplication.service;
//
//import com.sha.springboottaxapplication.model.FileUpload;
//import com.sha.springboottaxapplication.repository.FileUploadRepository;
//import com.sha.springboottaxapplication.repository.projection.FileItem;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public abstract class FileUploadServiceImpl implements FileUploadService{
//
//
//    private final FileUploadRepository fileUploadRepository;
//
//    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository){
//        this.fileUploadRepository = fileUploadRepository;
//    }
//
//    @Override
//    public FileUpload saveFileUpload(FileUpload fileUpload){
//        fileUpload.setUploadTime(LocalDateTime.now());
//        return fileUploadRepository.save(fileUpload);
//    }
//
//    @Override
//    public List<FileItem> findAllUploadsFilebyUser(Long userId){
//        return fileUploadRepository.findAllUploadsFilebyUser(userId);
//    }
//
//}
