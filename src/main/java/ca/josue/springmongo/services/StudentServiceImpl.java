package ca.josue.springmongo.services;

import ca.josue.springmongo.dto.StudentDto;
import ca.josue.springmongo.models.Student;
import ca.josue.springmongo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto findStudentById(String id) {
        return studentRepository
                .findById(id)
                .stream()
                .map(this::convertToDto)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student not found."));
    }

    @Override
    public StudentDto saveStudent(StudentDto student) {
        Student studentSaved = studentRepository
                .insert(this.convertToModel(student));
        return this.convertToDto(studentSaved);
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository
              .deleteById(id);
    }

    private StudentDto convertToDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .fullName(student.getFullname())
                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }

    private Student convertToModel(StudentDto student) {
        return Student.builder()
               .id(student.getId())
               .fullname(student.getFullName())
               .email(student.getEmail())
               .age(student.getAge())
               .build();
    }
}
