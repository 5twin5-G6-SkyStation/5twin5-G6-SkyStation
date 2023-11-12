package tn.esprit.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long numCourse;
    private int level;
    private TypeCourse typeCourse;
    private Support support;
    private Float price;
    private int timeSlot;

    // No need to include the 'registrations' field in the DTO
}
