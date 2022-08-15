package com.sha.springboottaxapplication.service;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;

@Service
public abstract class FilesStorageServiceImpl implements FilesStorageService{

    //private String path = "E:\\Tax\\Tax-Frontend-ll\\Documents\\";
    private String path = "E:\\Tax\\Tax-Frontend-v2\\Documents\\";
    //private final Path root = Paths.get("E:\\Tax\\Tax-Frontend-ll\\Documents\\");
    private final Path root = Paths.get("E:\\Tax\\Tax-Frontend-v2\\Documents\\");

    @Override
    public void init(){
        try{
            Files.createDirectory(root);
        }catch (IOException e){
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file){
        try{
            Files.copy(file.getInputStream(), this.root.resolve(path + file.getOriginalFilename()));
        }catch (Exception e){
            throw new RuntimeException("Error 01: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: 2" + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }



}
