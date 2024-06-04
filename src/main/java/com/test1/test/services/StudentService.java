package com.test1.test.services;

import com.test1.test.DAO.StudentDAO;
import com.test1.test.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public Student addStudent(Student student) {
        Student studentSaved = studentDAO.save(student);
        return studentSaved;
    }

    public Student searchById(Long id) {
        Student student = studentDAO.findById(id).orElse(null);
            return student;
    }
    public List<Student> searchAll(){
        List<Student> studentList = studentDAO.findAll();
        return studentList;
    }
    public Student updateStudentById(Long id, Student student){
        Student studentToUpdate = studentDAO.findById(id).orElse(null);
        if(studentToUpdate != null){
            studentToUpdate.setName(student.getName());
            studentToUpdate.setSurname(student.getSurname());
           Student studentUpdated = studentDAO.save(studentToUpdate);
           return studentUpdated;
        }
        return null;
    }
    public Student updateIsWorking(Long id, boolean isWorking){
        Student studentToUpdate = studentDAO.findById(id).orElse(null);
        if(studentToUpdate != null){
            studentToUpdate.setIsWorking(isWorking);
            Student studentUpdated = studentDAO.save(studentToUpdate);
            return studentUpdated;
        }
        return null;
    }
    public Student deleteStudentById(Long id){
         studentDAO.deleteById(id);
        return null;
    }
}
