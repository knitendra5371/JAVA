package com.swgr.controllers;

import com.swgr.models.Student;
import com.swgr.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Tag(name = "Student Controller", description = "To perform Operations on students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    @Operation(summary = "POST operation on student",
            description = "It's used to save student object in database")
    @ApiResponse(description = "Student saved in DB successfully",responseCode = "200")
    @ApiResponse(description = "Student did not save in DB : Internal Server Error",responseCode = "500")
    public Student save(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/list")
    @Operation(summary = "GET operation on students",
            description = "It's used to retrieve all student objects from database")
    public List<Student> getAll() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    @Operation(summary = "GET operation on student",
            description = "It's used to retrieve student object from database by student id")
    @ApiResponses(value = {@ApiResponse(
            description = "Student Details found Successfully",responseCode = "200"
    ),@ApiResponse(
            description = "Student not found",responseCode = "404"
    )})
    public Optional<Student> getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "DELETE operation on student",
            description = "It's used to delete a student object from database by student id")
    public void deleteById(@PathVariable Integer id) {
        studentService.deleteById(id);
    }

    @PutMapping("/update")
    @Operation(summary = "PUT operation on student",
            description = "It's used to update a student object in database")
    public Student update(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

}
