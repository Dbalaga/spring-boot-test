package com.example.spring_boot_demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Subject {
    @Field("subject_name")
    private String subjectName;
    @Field("marks_obtained")
    private String marksObtained;
}
