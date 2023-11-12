package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class CourseServicesImpl implements  ICourseServices{

    private ICourseRepository courseRepository;
    private static final Logger logger = LoggerFactory.getLogger(CourseServicesImpl.class);


    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        try {
            // log course object just for debugging
            logger.debug(course.toString());

            Course addedCourse = courseRepository.save(course);

            // log course object as info post insertion including the ID
            logger.info(addedCourse.toString());
            return addedCourse;
        } catch (Exception ex) {
            // log the exception message
            logger.error(ex.getMessage());
            return  null;
        }
    }

    @Override
    public Course updateCourse(Course course) {
        try {
            // log course object just for debugging
            logger.debug(course.toString());

            Course addedCourse = courseRepository.save(course);

            // log course object as info post insertion including the ID
            logger.info(addedCourse.toString());
            return addedCourse;
        } catch (Exception ex) {
            // log the exception message
            logger.error(ex.getMessage());
            return  null;
        }
    }

    @Override
    public Course retrieveCourse(Long numCourse) {
        try {
            // log course num to retrieve
            logger.info(numCourse.toString());
            return courseRepository.findById(numCourse).orElse(null);
        } catch (Exception ex) {
            // log the exception message
            logger.error(ex.getMessage());
            return  null;
        }
    }


}
