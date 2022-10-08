package ca.josue.springmongo.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-10-08
 */
@Data
@Builder
public class StudentDto {
    private final String id;
    private final String fullName;
    private final String email;
    private final int age;
}
