package tn.esprit.spring;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.RegistrationServicesImpl;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.spring.entities.TypeCourse;
import java.util.List;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class RegistrationTestImpl {

    @InjectMocks
    RegistrationServicesImpl registrationServices;

    @Mock
    IRegistrationRepository registrationRepository;

    @Mock
    ISkierRepository skierRepository;

    @Mock
    ICourseRepository courseRepository;



    @Test
    @Order(1)
    void testAddRegistrationAndAssignToSkier() {
        Skier skier = new Skier();
        skier.setNumSkier(1L);

        Registration registration = new Registration();
        registration.setSkier(skier);

        Mockito.when(skierRepository.findById(1L)).thenReturn(Optional.of(skier));
        Mockito.when(registrationRepository.save(Mockito.any(Registration.class))).thenReturn(registration);

        Registration result = registrationServices.addRegistrationAndAssignToSkier(registration, 1L);

        assertNotNull(result);
        assertEquals(result.getSkier(), skier);
    }

    @Test
    @Order(2)
    void testAssignRegistrationToCourse() {
        Course course = new Course();
        course.setNumCourse(1L);

        Registration registration = new Registration();
        registration.setCourse(course);

        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        Mockito.when(registrationRepository.save(Mockito.any(Registration.class))).thenReturn(registration);

        Registration result = registrationServices.assignRegistrationToCourse(1L, 1L);

        assertNotNull(result);
        assertEquals(result.getCourse(), course);
    }

    @Test
    @Order(3)
    void testAddRegistrationAndAssignToSkierAndCourse() {
        Skier skier = new Skier();
        skier.setNumSkier(1L);

        Course course = new Course();
        course.setNumCourse(1L);
        course.setTypeCourse(TypeCourse.INDIVIDUAL);

        Registration registration = new Registration();
        registration.setNumWeek(1);

        Mockito.when(skierRepository.findById(1L)).thenReturn(Optional.of(skier));
        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        Mockito.when(registrationRepository.countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(1, 1L, 1L)).thenReturn(0L);

        Registration result = registrationServices.addRegistrationAndAssignToSkierAndCourse(registration, 1L, 1L);

        assertNotNull(result);
        assertEquals(result.getSkier(), skier);
        assertEquals(result.getCourse(), course);
    }

    @Test
    @Order(4)
    void testNumWeeksCourseOfInstructorBySupport() {
        Instructor instructor = new Instructor();
        instructor.setNumInstructor(1L);
        Support support = Support.SKI;

        // Créer une liste avec les numéros de semaine
        List<Integer> weeks = new ArrayList<>(Arrays.asList(1, 2, 3));

        // Mock de la méthode avec la liste créée
        Mockito.when(registrationRepository.numWeeksCourseOfInstructorBySupport(1L, support)).thenReturn(weeks);

        List<Integer> result = registrationServices.numWeeksCourseOfInstructorBySupport(1L, support);

        assertNotNull(result);
        assertEquals(3, result.size());
    }


    // Ajoutez d'autres tests selon les autres méthodes de votre service
}
