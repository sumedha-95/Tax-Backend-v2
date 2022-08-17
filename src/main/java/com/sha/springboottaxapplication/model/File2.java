package com.sha.springboottaxapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class File2 {

    @Id
    private String id;

//    @Column(name="data")
//    private String date;
}
