import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.controllers.PisteRestController;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.services.IPisteServices;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PisteRestControllerTest {

    @InjectMocks
    PisteRestController pisteRestController;

    @Mock
    IPisteServices pisteServices;

    @BeforeEach
    void setUp() {
        // Initialisation de Mockito
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void testAddPiste() {
        // Créez un objet Piste factice pour les tests
        Piste piste = new Piste();
        piste.setNom("Ma piste de test");

        // Définissez le comportement attendu lors de l'appel au service
        Mockito.when(pisteServices.addPiste(Mockito.any(Piste.class))).thenReturn(piste);

        // Appelez la méthode du contrôleur que vous voulez tester
        Piste result = pisteRestController.addPiste(piste);

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals("Ma piste de test", result.getNom());
    }

    @Test
    @Order(2)
    void testGetAllPistes() {
        // Créez une liste factice de pistes pour les tests
        List<Piste> pistes = new ArrayList<>();
        pistes.add(new Piste("Piste 1"));
        pistes add(new Piste("Piste 2"));

        // Définissez le comportement attendu lors de l'appel au service
        Mockito.when(pisteServices.retrieveAllPistes()).thenReturn(pistes);

        // Appelez la méthode du contrôleur que vous voulez tester
        List<Piste> result = pisteRestController.getAllPistes();

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Piste 1", result.get(0).getNom());
    }

    @Test
    @Order(3)
    void testGetById() {
        // Créez un objet Piste factice pour les tests
        Piste piste = new Piste();
        piste.setNom("Ma piste de test");

        // Définissez le comportement attendu lors de l'appel au service
        Mockito.when(pisteServices.retrievePiste(1L)).thenReturn(piste);

        // Appelez la méthode du contrôleur que vous voulez tester
        Piste result = pisteRestController.getById(1L);

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals("Ma piste de test", result.getNom());
    }

    @Test
    @Order(4)
    void testDeleteById() {
        // Définissez le comportement attendu lors de l'appel au service (void)
        Mockito.doNothing().when(pisteServices).removePiste(1L);

        // Appelez la méthode du contrôleur que vous voulez tester
        pisteRestController.deleteById(1L);

    }
}
