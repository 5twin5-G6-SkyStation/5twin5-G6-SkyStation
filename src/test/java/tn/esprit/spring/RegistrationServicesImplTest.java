package tn.esprit.spring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.controllers.RegistrationRestController;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.CourseServicesImpl;
import tn.esprit.spring.services.IRegistrationServices;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class RegistrationServicesImplTest {

    @Autowired
    private RegistrationRestController registrationRestController;

    @Autowired
    private IRegistrationServices registrationServices;

    @Autowired
    private SkierServicesImpl skierServices;


    @Autowired
    private CourseServicesImpl courseServices;

    @Autowired
    private ISkierRepository skierRepository;

    @Autowired
    private IRegistrationRepository registrationRepository;


    @Test
    @Order(1)

    public void testAddAndAssignToSkier() {
        // Exemple de données de test
        Registration registration = new Registration();
        Long numSkier = 1L;

        // Créez un skieur réel (vous pouvez également le récupérer à partir de la base de données si nécessaire)
        Skier skier = new Skier();
        skier.setNumSkier(numSkier);

        // Enregistrez le skieur dans le repository (simulez le comportement réel de l'enregistrement)
        skierRepository.save(skier);

        // Appeler directement la méthode du service
        Registration result = registrationServices.addRegistrationAndAssignToSkier(registration, numSkier);

        // Effectuer les assertions sur le résultat
        assertNotNull(result);
        assertNotNull(result.getSkier());
        assertEquals(numSkier, result.getSkier().getNumSkier());

        // Vérifiez que l'enregistrement a été sauvegardé dans le repository
        Registration savedRegistration = registrationRepository.findById(result.getNumRegistration()).orElse(null);
        assertNotNull(savedRegistration);
        assertEquals(numSkier, savedRegistration.getSkier().getNumSkier());

        // Ajouter des assertions supplémentaires en fonction de votre logique métier
    }


    @Test
    @Order(2)
    public void testAssignToCourse() {
        // Exemple de données de test
        Long numRegistration = 1L;
        Long numCourse = 1L;

        // Configurer le comportement du service réel (ou ne rien faire, selon le besoin)

        // Appeler directement la méthode du contrôleur
        Registration result = registrationRestController.assignToCourse(numRegistration, numCourse);

        // Effectuer les assertions sur le résultat
        assertNotNull(result);
        // Ajouter des assertions supplémentaires en fonction de votre logique métier
    }

    @Test
    @Order(3)
    public void testAddAndAssignToSkierAndCourse() {
        // Exemple de données de test
        Registration registration = new Registration();
        Long numSkieur = 1L;
        Long numCourse = 1L;

        // Configurer le comportement du service réel (ou ne rien faire, selon le besoin)

        // Appeler directement la méthode du contrôleur
        Registration result = registrationRestController.addAndAssignToSkierAndCourse(registration, numSkieur, numCourse);

        // Effectuer les assertions sur le résultat
     //   Assertions.assertNotNull(result);
        // Ajouter des assertions supplémentaires en fonction de votre logique métier
    }

    @Test
    @Order(4)
    public void testNumWeeksCourseOfInstructorBySupport() {
        // Exemple de données de test
        Long numInstructor = 1L;
        Support support = Support.SKI;

        // Configurer le comportement du service réel (ou ne rien faire, selon le besoin)

        // Appeler directement la méthode du contrôleur
        List<Integer> result = registrationRestController.numWeeksCourseOfInstructorBySupport(numInstructor, support);

        // Effectuer les assertions sur le résultat
        assertNotNull(result);
        // Ajouter des assertions supplémentaires en fonction de votre logique métier
    }

    // Ajoutez d'autres méthodes de test pour les autres endpoints du contrôleur...

}

