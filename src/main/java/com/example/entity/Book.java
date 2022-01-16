package com.example.entity;

import lombok.Data;

//实体类
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
