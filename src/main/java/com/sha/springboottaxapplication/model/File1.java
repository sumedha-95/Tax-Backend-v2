package com.sha.springboottaxapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file")
public class File1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

//    private String status;

    private String user_id;

    private String message;

    @Lob
    @Column
    private byte[] data;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
