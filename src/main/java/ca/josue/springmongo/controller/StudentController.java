package ca.josue.springmongo.controller;

import ca.josue.springmongo.dto.StudentDto;
import ca.josue.springmongo.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDto> allStudents () {
        return this.studentService.findAllStudents();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto getStudentById (@PathVariable String id) {
        return this.studentService.findStudentById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto addStudent (@RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent (@PathVariable String id) {
        this.studentService.deleteStudentById(id);
    }
}
