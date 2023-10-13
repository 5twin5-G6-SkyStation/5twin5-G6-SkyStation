package tn.esprit.spring;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.services.IInstructorServices;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorTest {
    @Autowired
    private IInstructorServices instructorService;

    @Test
    public void testAddInstructor() {
        // Test unitaire
        List<Instructor> instructors = instructorService.retrieveAllInstructors();
        int expected = instructors.size();
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        instructor.setDateOfHire(LocalDate.now());
        Instructor savedInstructor = instructorService.addInstructor(instructor);

        assertEquals(expected + 1, instructorService.retrieveAllInstructors().size());
        assertNotNull(savedInstructor.getNumInstructor());
        instructorService.retrieveInstructor(savedInstructor.getNumInstructor());
    }

    @Test
    public void testAddInstructorWithMockito() {
        // Test Mockito
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        instructor.setDateOfHire(LocalDate.now());

        IInstructorServices mockService = mock(IInstructorServices.class);
        when(mockService.addInstructor(instructor)).thenReturn(instructor);

        Instructor savedInstructor = mockService.addInstructor(instructor);

        assertNotNull(savedInstructor.getNumInstructor());
        assertEquals("John", savedInstructor.getFirstName());
        assertEquals("Doe", savedInstructor.getLastName());
    }

    @Test
    public void testDeleteInstructor() {
        // Test unitaire
        Instructor instructor = new Instructor();
        instructor.setFirstName("Alice");
        instructor.setLastName("Johnson");
        instructor.setDateOfHire(LocalDate.now());
        Instructor savedInstructor = instructorService.addInstructor(instructor);

        instructorService.retrieveInstructor(savedInstructor.getNumInstructor());
        assertNull(instructorService.retrieveInstructor(savedInstructor.getNumInstructor()));
    }

    @Test
    public void testDeleteInstructorWithMockito() {
        // Test Mockito
        Instructor instructor = new Instructor();
        instructor.setFirstName("Alice");
        instructor.setLastName("Johnson");
        instructor.setDateOfHire(LocalDate.now());

        IInstructorServices mockService = mock(IInstructorServices.class);
        when(mockService.addInstructor(instructor)).thenReturn(instructor);
        Instructor savedInstructor = mockService.addInstructor(instructor);

        when(mockService.retrieveInstructor(savedInstructor.getNumInstructor())).thenReturn(savedInstructor);
        when(mockService.retrieveInstructor(savedInstructor.getNumInstructor())).thenReturn(null);

        Instructor retrievedInstructor = mockService.retrieveInstructor(savedInstructor.getNumInstructor());
        assertNotNull(retrievedInstructor);

        Instructor deletedInstructor = mockService.retrieveInstructor(savedInstructor.getNumInstructor());
        assertNull(deletedInstructor);
    }
}
