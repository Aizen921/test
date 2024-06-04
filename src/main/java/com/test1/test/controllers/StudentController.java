package com.test1.test.controllers;

import com.test1.test.entities.Student;
import com.test1.test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity <Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.addStudent(student));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.searchById(id);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/list")
    public List<Student> getAllStudent(){
        return studentService.searchAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentByid(@PathVariable Long id, @RequestBody Student student){
    Student studentToUpdate = studentService.updateStudentById(id, student);
        return ResponseEntity.ok().body(studentToUpdate);

    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Student> deleteById(@PathVariable Long id){
        Student studentToDelete = studentService.deleteStudentById(id);
        return ResponseEntity.ok().body(studentToDelete);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateIsWorking(@PathVariable Long id, @RequestParam boolean isWorking){
        Student studentToUpdate = studentService.updateIsWorking(id, isWorking);
        return ResponseEntity.ok().body(studentToUpdate);
    }
}
