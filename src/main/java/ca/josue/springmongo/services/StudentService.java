package ca.josue.springmongo.services;

import ca.josue.springmongo.dto.StudentDto;

import java.util.List;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
public interface StudentService {
    List<StudentDto> findAllStudents();

    StudentDto findStudentById(String id);

    StudentDto saveStudent(StudentDto student);

    void deleteStudentById(String id);
}
