package com.luv2code.com.demo.rest;

import com.luv2code.com.demo.exception.StudentErrorResponse;
import com.luv2code.com.demo.exception.StudentNotFoundException;
import com.luv2code.com.demo.pojo.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Cash", "Patenema"));
        students.add(new Student("Condolisa", "Rice"));
        students.add(new Student("Lebron", "James"));
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok()
                .header("X-Total count", String.valueOf(students.size()))
                .header("API-Version","v1.0")
                .body(students);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId) {

        // check the student ID against the list size
        if(studentId > students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return ResponseEntity.ok(students.get(studentId));
    }


}
