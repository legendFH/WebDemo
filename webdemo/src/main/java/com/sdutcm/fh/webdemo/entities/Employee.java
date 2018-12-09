package com.sdutcm.fh.webdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private int id;
    private String lastName;
    private String email;
    private int gender;
    private String department;
    private Date birth;


}
