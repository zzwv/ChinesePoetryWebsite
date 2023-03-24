package com.zzwv.dto;

import lombok.Data;

// getter，setter，toString，equals，hashCode等操作
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
