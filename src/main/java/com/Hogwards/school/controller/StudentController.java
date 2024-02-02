package com.Hogwards.school.controller;


import com.Hogwards.school.model.Student;
import com.Hogwards.school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/filtered")
    public Collection<Student> getByAge(@RequestParam("age") int age){
        return studentService.getByAge(age);
    }

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student read(@PathVariable("id") Long id) {
        return studentService.read(id);
    }

    @PostMapping("/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Student remove(@PathVariable("id") Long id) {
        return studentService.delete(id);
    }
}
