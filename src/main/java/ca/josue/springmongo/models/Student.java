package ca.josue.springmongo.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
@Data
@Builder
@Document("students")
public class Student {
    private final String id;
    private final String fullname;
    private final String email;
    private final int age;
}
