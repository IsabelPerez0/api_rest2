package edu.uptc.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uptc.apirest.entities.Student;
import edu.uptc.apirest.services.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Iterable <Student> get(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student std){

        return studentService.save(std);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student std, @PathVariable int id){
        return studentService.update(std);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable("id") int id){
        return studentService.delete(id);
    }
    
}
