package tn.esprit.spring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.spring.controllers.RegistrationRestController;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.services.IRegistrationServices;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RegistrationRestControllerTest {

    @Mock
    private IRegistrationServices registrationServices;

    @InjectMocks
    private RegistrationRestController registrationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddAndAssignToSkier() {
        Registration registration = new Registration();
        when(registrationServices.addRegistrationAndAssignToSkier(registration, 1L)).thenReturn(registration);

        Registration result = registrationController.addAndAssignToSkier(registration, 1L);

        assertEquals(registration, result);
        verify(registrationServices, times(1)).addRegistrationAndAssignToSkier(registration, 1L);
    }

    @Test
    void testAssignToCourse() {
        Registration registration = new Registration();
        when(registrationServices.assignRegistrationToCourse(1L, 2L)).thenReturn(registration);

        Registration result = registrationController.assignToCourse(1L, 2L);

        assertEquals(registration, result);
        verify(registrationServices, times(1)).assignRegistrationToCourse(1L, 2L);
    }

    @Test
    void testAddAndAssignToSkierAndCourse() {
        Registration registration = new Registration();
        when(registrationServices.addRegistrationAndAssignToSkierAndCourse(registration, 1L, 2L)).thenReturn(registration);

        Registration result = registrationController.addAndAssignToSkierAndCourse(registration, 1L, 2L);

        assertEquals(registration, result);
        verify(registrationServices, times(1)).addRegistrationAndAssignToSkierAndCourse(registration, 1L, 2L);
    }

    @Test
    void testNumWeeksCourseOfInstructorBySupport() {
        List<Integer> weeks = Arrays.asList(1, 2, 3);
        when(registrationServices.numWeeksCourseOfInstructorBySupport(1L, Support.SKI)).thenReturn(weeks);

        List<Integer> result = registrationController.numWeeksCourseOfInstructorBySupport(1L, Support.SKI);

        assertEquals(weeks, result);
        verify(registrationServices, times(1)).numWeeksCourseOfInstructorBySupport(1L, Support.SKI);
    }
}
