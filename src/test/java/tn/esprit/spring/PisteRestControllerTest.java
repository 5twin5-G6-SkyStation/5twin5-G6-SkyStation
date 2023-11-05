
package tn.esprit.spring;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class PisteRestControllerTest {

    @InjectMocks
    IPisteRepository iPisteRepository;

    @Mock
    @Autowired
    PisteServicesImpl pisteServices;

    @Test
    @Order(1)
    public void testAddPiste() {
        Piste newPiste = new Piste();
        newPiste.setNamePiste("Piste Name");
        newPiste.setLength(1000);
        newPiste.setSlope(20);

        Piste addedPiste = pisteServices.addPiste(newPiste);
        Assertions.assertNotNull(addedPiste);
    }

    @Test
    @Order(2)
    public void testRetrieveAllPistes() {
        List<Piste> listPistes = pisteServices.retrieveAllPistes();
        Assertions.assertTrue(listPistes.size() > 0);
    }

    @Test
    @Order(3)
    public void testRetrievePiste() {
        // Create a new Piste object
        Piste newPiste = new Piste();
        newPiste.setNamePiste("Piste Name");
        newPiste.setLength(1000);
        newPiste.setSlope(20);

        // Mock the behavior of pisteServices to return the newPiste when retrievePiste is called
        Mockito.when(pisteServices.retrievePiste(Mockito.anyLong())).thenReturn(newPiste);

        // Call the method you want to test
        Piste retrievedPiste = pisteServices.retrievePiste(1L); // Use an appropriate pisteId

        // Assert that the retrievedPiste is not null
        Assertions.assertNotNull(retrievedPiste);
    }


    @Test
    @Order(4)
    public void testDeletePiste() {
        Piste newPiste = new Piste();
        newPiste.setNamePiste("Piste Name");
        newPiste.setLength(1000);
        newPiste.setSlope(20);

        Piste addedPiste = pisteServices.addPiste(newPiste);
        Long pisteId = addedPiste.getNumPiste();

        pisteServices.removePiste(pisteId);

        Piste deletedPiste = pisteServices.retrievePiste(pisteId);
        Assertions.assertNull(deletedPiste);
    }
} 