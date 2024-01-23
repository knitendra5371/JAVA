package com.swaggerdemo.services;

import com.swaggerdemo.models.Student;
import com.swaggerdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getById(Integer id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void deleteById(Integer id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

}
