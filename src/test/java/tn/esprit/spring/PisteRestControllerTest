package tn.esprit.spring;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.controllers.PisteRestController;
import tn.esprit.spring.entities.Piste;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PisteRestControllerTest {

    @Autowired
    private PisteRestController pisteRestController;

    @Test
    public void testAddPiste() {
        // Créez un objet Piste factice pour les tests
        Piste piste = new Piste();
        piste.setNom("Ma piste de test");

        // Appelez la méthode du contrôleur que vous voulez tester
        Piste result = pisteRestController.addPiste(piste);

        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals("Ma piste de test", result.getNom());
    }

    @Test
    public void testGetAllPistes() {
        // Créez une liste factice de pistes pour les tests
        Piste piste1 = new Piste("Piste 1");
        Piste piste2 = new Piste("Piste 2");
        List<Piste> pistes = new ArrayList<>();
        pistes.add(piste1);
        pistes.add(piste2);
    
        // Appelez la méthode du contrôleur que vous voulez tester
        List<Piste> result = pisteRestController.getAllPistes();
    
        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals(2, result.size()); // Vérifiez le nombre d'éléments dans la liste, par exemple
        assertEquals("Piste 1", result.get(0).getNom());
        assertEquals("Piste 2", result.get(1).getNom());
    }
    
    @Test
    public void testGetById() {
        // Créez un objet Piste factice pour les tests
        Piste piste = new Piste();
        piste.setNom("Ma piste de test");
        Long pisteId = 1L;
    
        // Appelez la méthode du contrôleur que vous voulez tester
        Piste result = pisteRestController.getById(pisteId);
    
        // Effectuez des assertions pour vérifier que le résultat est conforme aux attentes
        assertNotNull(result);
        assertEquals(pisteId, result.getId());
        assertEquals("Ma piste de test", result.getNom());
    }
    
    @Test
    public void testDeleteById() {
        // Identifiant de la piste à supprimer
        Long pisteId = 1L;
    
        // Appelez la méthode du contrôleur que vous voulez tester
        pisteRestController.deleteById(pisteId);
    
        // Vous pouvez ajouter des assertions supplémentaires pour vérifier la suppression, par exemple
        Piste deletedPiste = pisteRestController.getById(pisteId);
        assertNull(deletedPiste);
    }
    
    
}