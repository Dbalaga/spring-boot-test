package com.example.spring_boot_demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Department {
    @Field("department_name")
    private String departmentName;
    private String location;
}
