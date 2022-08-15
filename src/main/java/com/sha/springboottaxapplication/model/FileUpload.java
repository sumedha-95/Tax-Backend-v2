package com.sha.springboottaxapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "fileUpload")
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id", insertable = false, updatable = false)//This is Foreign key
    private User user;

    @Column(name = "file_id")
    private Long fileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id",referencedColumnName = "id",insertable = false,updatable = false)
    private File1 file;

    @Column(name = "url")
    private String url;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;
}
