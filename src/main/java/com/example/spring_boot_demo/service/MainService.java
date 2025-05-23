package com.example.spring_boot_demo.service;

import com.example.spring_boot_demo.model.Student;
import com.example.spring_boot_demo.repository.StudentRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MainService {
  @Autowired MongoTemplate mongoTemplate;
  @Autowired StudentRepository studentRepository;

  public long testMongodb() {
    return mongoTemplate.getCollection("student").countDocuments();
  }


  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student getStudentById(String id) {
    Student student = studentRepository.findById(id).get();
    return student;
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student updateStudentById(Student student) {
    return studentRepository.save(student);
  }

  public String deleteStudentById(String id) {
    studentRepository.deleteById(id);
    return "Student Deleted Successfully...";
  }

  public List<Student> getStudentsByName(String name) {
    return studentRepository.findByName(name);
  }

  public List<Student> getStudentsByNameAndMail(String name, String email) {
    return studentRepository.findByNameAndEmail(name,email);
  }

  public List<Student> getStudentsByNameOrMail(String name, String email) {
    return studentRepository.findByNameOrEmail(name,email);
  }

  public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo,pageSize);
    return studentRepository.findAll(pageable).getContent();
  }

  public List<Student> getAllStudentsWithSorting() {
    Sort sort = Sort.by(Sort.Direction.DESC,"name");
    return studentRepository.findAll(sort);
  }

  public List<Student> getStudentsByDepartmentName(String deptName) {
    return studentRepository.findByDepartmentDepartmentName(deptName);
  }

  public List<Student> getStudentsBySubjectName(String subjectName) {
    return  studentRepository.findBySubjectsSubjectName(subjectName);
  }

  public List<Student> getStudentsNameStartsWith(String name) {
    return studentRepository.findByNameStartsWith(name);
  }
}
