package com.example.spring_boot_demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("student")
@Data
public class Student {
  @Id private String id;
  private String name;

  @Field("mail")
  private String email;

  private Department department;
  private List<Subject> subjects;
}
