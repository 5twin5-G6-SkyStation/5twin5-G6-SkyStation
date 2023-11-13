package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.services.ICourseServices;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CourseControllerWoMockTest {

        @Autowired
        ICourseServices courseService;

        @Test
        @Order(1)
        void testAddClient() throws ParseException {

            Course course = new Course(1L, 1, TypeCourse.INDIVIDUAL, Support.SKI, 1.3F, 1);

            Course insertedCourse = courseService.addCourse(course);
            log.info("client "+course);
            assertNotNull(insertedCourse.getNumCourse());
            assertNotNull(insertedCourse.getTypeCourse());
            courseService.deleteCourse(insertedCourse.getNumCourse());

        }
}
