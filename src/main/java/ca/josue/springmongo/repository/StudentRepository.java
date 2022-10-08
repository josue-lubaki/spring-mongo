package ca.josue.springmongo.repository;

import ca.josue.springmongo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
public interface StudentRepository extends MongoRepository<Student, String> {
}
