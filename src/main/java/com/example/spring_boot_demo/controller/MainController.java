package com.example.spring_boot_demo.controller;

import com.example.spring_boot_demo.model.Student;
import com.example.spring_boot_demo.service.MainService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
  private static final Logger log = LoggerFactory.getLogger(MainController.class);
  @Autowired MainService mainService;

  @GetMapping("/test")
  public ResponseEntity<String> testService() {
    return new ResponseEntity<>("Application test successful...", HttpStatusCode.valueOf(200));
  }

  @GetMapping("/testMongo")
  public ResponseEntity<String> testMongoDb() {
    long numOfDocs = mainService.testMongodb();
    log.info("Number of documents in student collections{}",numOfDocs);
    return ResponseEntity.ok("Mongo Connection Success...");
  }

  @PostMapping("/saveStudent")
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    return ResponseEntity.ok(mainService.saveStudent(student));
  }

  @GetMapping("getStudentById/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable String id) {
    return ResponseEntity.ok(mainService.getStudentById(id));
  }

  @GetMapping("getAllStudents")
  public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok(mainService.getAllStudents());
  }

  @PostMapping("/updateStudentById")
  public ResponseEntity<Student> updateStudentById(@RequestBody Student student) {
    return ResponseEntity.ok(mainService.updateStudentById(student));
  }

  @GetMapping("deleteStudentById/{id}")
  public ResponseEntity<String> deleteStudentById(@PathVariable String id) {
    return ResponseEntity.ok(mainService.deleteStudentById(id));
  }

  @GetMapping("findStudentByName/{name}")
  public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name){
    return ResponseEntity.ok(mainService.getStudentsByName(name));
  }
  @GetMapping("findStudentByNameAndMail")
  public ResponseEntity<List<Student>> getStudentsByNameAndMail(@RequestParam String name, @RequestParam String email){
    return ResponseEntity.ok(mainService.getStudentsByNameAndMail(name,email));
  }
  @GetMapping("findStudentByNameOrMail")
  public ResponseEntity<List<Student>> getStudentsByNameOrMail(@RequestParam String name, @RequestParam String email){
    return ResponseEntity.ok(mainService.getStudentsByNameOrMail(name,email));
  }

  @GetMapping("findAllStudentsWithPagination")
  public ResponseEntity<List<Student>> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
    return ResponseEntity.ok(mainService.getAllStudentsWithPagination(pageNo,pageSize));
  }
  @GetMapping("findAllStudentsWithSorting")
  public ResponseEntity<List<Student>> getAllStudentsWithSorting(){
    return ResponseEntity.ok(mainService.getAllStudentsWithSorting());
  }
  @GetMapping("findStudentsByDepartmentName")
  public ResponseEntity<List<Student>> getStudentsByDepartmentName(@RequestParam String deptName){
    return ResponseEntity.ok(mainService.getStudentsByDepartmentName(deptName));
  }
  @GetMapping("findStudentsBySubjectName")
  public ResponseEntity<List<Student>> getStudentsBySubjectName(@RequestParam String subjectName){
    return ResponseEntity.ok(mainService.getStudentsBySubjectName(subjectName));
  }
  @GetMapping("findStudentsNameStartsWith")
  public ResponseEntity<List<Student>> getStudentsNameStartsWith(@RequestParam String name){
    return ResponseEntity.ok(mainService.getStudentsNameStartsWith(name));
  }
}
