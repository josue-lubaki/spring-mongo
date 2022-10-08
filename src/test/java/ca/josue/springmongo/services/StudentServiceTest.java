package ca.josue.springmongo.services;

import ca.josue.springmongo.models.Student;
import ca.josue.springmongo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;


/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentService underTestService;

    @BeforeEach
    public void setUp() {
        underTestService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void canGetAllStudents() {
        // when
        underTestService.findAllStudents();

        // verify
        verify(studentRepository).findAll();
    }

    @Test
    public void canGetStudentById() {
        // given
        Student student = Student
                .builder()
                .id("1")
                .build();
        when(studentRepository.findById(any())).thenReturn(Optional.of(student));

        // when
        underTestService.findStudentById(anyString());

        // verify
        verify(studentRepository).findById(any());
    }

    @Test
    public void canDeleteStudentById() {
        underTestService.deleteStudentById(anyString());

        verify(studentRepository).deleteById(any());
    }
}
