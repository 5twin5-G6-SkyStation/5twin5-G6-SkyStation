import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.controllers.PisteRestController;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.services.PisteServicesImpl;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PisteRestControllerTest {

    @InjectMocks
    private PisteRestController pisteRestController;

    @Mock
    private PisteServicesImpl pisteServices;

    @Test
    @Order(1)
    public void testAddPiste() {
        // Créez une nouvelle piste pour le test
        Piste newPiste = new Piste();
        newPiste.setNamePiste("Piste Name");
        newPiste.setLength(1000);
        newPiste.setSlope(20);

        // Définissez le comportement simulé de pisteServices.addPiste
        Mockito.when(pisteServices.addPiste(newPiste)).thenReturn(newPiste);

        // Appelez la méthode que vous voulez tester
        Piste addedPiste = pisteRestController.addPiste(newPiste);

        // Assurez-vous que la piste ajoutée n'est pas nulle
        Assertions.assertNotNull(addedPiste);
    }

    @Test
    @Order(2)
    public void testRetrieveAllPistes() {
        // Créez une liste de pistes simulée pour le test
        List<Piste> simulatedPistes = List.of(new Piste(), new Piste());

        // Définissez le comportement simulé de pisteServices.retrieveAllPistes
        Mockito.when(pisteServices.retrieveAllPistes()).thenReturn(simulatedPistes);

        // Appelez la méthode que vous voulez tester
        List<Piste> listPistes = pisteRestController.retrieveAllPistes();

        // Assurez-vous que la liste de pistes n'est pas vide
        Assertions.assertFalse(listPistes.isEmpty());
    }

    @Test
    @Order(3)
    public void testRetrievePiste() {
        // Créez une nouvelle piste simulée pour le test
        Piste simulatedPiste = new Piste();
        simulatedPiste.setNamePiste("Piste Name");
        simulatedPiste.setLength(1000);
        simulatedPiste.setSlope(20);

        // Définissez le comportement simulé de pisteServices.retrievePiste
        Mockito.when(pisteServices.retrievePiste(Mockito.anyLong())).thenReturn(simulatedPiste);

        // Appelez la méthode que vous voulez tester
        Piste retrievedPiste = pisteRestController.retrievePiste(1L); // Utilisez un identifiant de piste approprié

        // Assurez-vous que la piste récupérée n'est pas nulle
        Assertions.assertNotNull(retrievedPiste);
    }

    @Test
    @Order(4)
    public void testDeletePiste() {
        // Créez une nouvelle piste pour le test
        Piste newPiste = new Piste();
        newPiste.setNamePiste("Piste Name");
        newPiste.setLength(1000);
        newPiste.setSlope(20);

        // Définissez le comportement simulé de pisteServices.addPiste
        Mockito.when(pisteServices.addPiste(newPiste)).thenReturn(newPiste);

        // Appelez la méthode pour ajouter une piste
        Piste addedPiste = pisteRestController.addPiste(newPiste);
        Long pisteId = addedPiste.getNumPiste();

        // Définissez le comportement simulé de pisteServices.removePiste
        Mockito.when(pisteServices.removePiste(pisteId)).thenReturn(true);

        // Appelez la méthode pour supprimer la piste
        boolean isDeleted = pisteRestController.removePiste(pisteId);

        // Assurez-vous que la piste est supprimée avec succès
        Assertions.assertTrue(isDeleted);
    }
}
