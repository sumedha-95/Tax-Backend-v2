//package com.sha.springboottaxapplication.controller;
//
//import com.sha.springboottaxapplication.model.FileUpload;
//import com.sha.springboottaxapplication.security.UserPrinciple;
//import com.sha.springboottaxapplication.service.FileUploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/uploardfiles")//path
//public class FileUploadController {
//
//    @Autowired(required = true)
//    private FileUploadService fileUploadService;
//
//    @PostMapping//api/uploardfiles
//    public ResponseEntity<?> saveUploadFile(@RequestBody FileUpload fileUpload){
////        return new ResponseEntity<>(fileUploadService.saveFileUpload(fileUpload), HttpStatus.CREATED);
//    }
//
//    @GetMapping//api/uploardfiles
//    public ResponseEntity<?> getAllUploadFileOfUser(@AuthenticationPrincipal UserPrinciple userPrinciple){
//        return ResponseEntity.ok(fileUploadService.findAllUploadsFilebyUser(userPrinciple.getId()));
//    }
//
//
//}
