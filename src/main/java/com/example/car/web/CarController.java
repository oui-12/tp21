// Déclaration du package pour organiser les classes
package com.example.car.web;

// Importations des classes nécessaires
import com.example.car.entities.Car;  // Entité Car représentant une voiture
import com.example.car.repositories.CarRepository;  // Interface pour les opérations CRUD sur les voitures
import com.example.car.services.ClientApi;  // Service pour communiquer avec le service Client
import org.springframework.web.bind.annotation.*;  // Annotations pour les contrôleurs REST

import java.util.List;  // Pour utiliser les listes

/**
 * Contrôleur REST pour gérer les opérations liées aux voitures.
 * Tous les points de terminaison sont préfixés par "/api/cars".
 */
@RestController  // Indique que cette classe est un contrôleur REST
@RequestMapping("/api/cars")  // Mappage de base pour toutes les routes de ce contrôleur
public class CarController {
    
    // Référence vers le repository pour accéder aux données des voitures
    private final CarRepository repo;
    // Service pour communiquer avec le microservice Client
    private final ClientApi clientApi;

    /**
     * Constructeur pour l'injection des dépendances.
     *
     * @param repo Le repository pour les opérations sur les voitures
     * @param clientApi Le service pour communiquer avec le service Client
     */
    public CarController(CarRepository repo, ClientApi clientApi) {
        this.repo = repo;
        this.clientApi = clientApi;
    }

    /**
     * Endpoint POST pour créer une nouvelle voiture.
     *
     * @param car Les données de la voiture à créer (au format JSON dans le corps de la requête)
     * @return La voiture créée avec son ID généré
     */
    @PostMapping  // Traite les requêtes HTTP POST sur /api/cars
    public Car save(@RequestBody Car car) {
        // Sauvegarde la voiture dans la base de données locale (carservicedb)
        return repo.save(car);
    }

    /**
     * Endpoint GET pour récupérer toutes les voitures.
     * Enrichit chaque voiture avec les informations du client associé.
     *
     * @return Une liste de toutes les voitures avec leurs clients associés
     */
    @GetMapping  // Traite les requêtes HTTP GET sur /api/cars
    public List<Car> findAll() {
        // Récupère toutes les voitures de la base de données
        List<Car> cars = repo.findAll();

        // Pour chaque voiture, enrichit avec les informations du client
        for (Car car : cars) {
            if (car.getClientId() != null) {
                // Appel au service Client pour récupérer les informations du client
                car.setClient(clientApi.findClientById(car.getClientId()));
            }
        }
        return cars;
    }

    /**
     * Endpoint GET pour récupérer toutes les voitures d'un client spécifique.
     *
     * @param clientId L'ID du client dont on veut les voitures
     * @return Une liste des voitures appartenant au client spécifié
     */
    @GetMapping("/byClient/{clientId}")  // Traite les requêtes GET sur /api/cars/byClient/{clientId}
    public List<Car> findByClient(@PathVariable Long clientId) {
        // Récupère toutes les voitures associées à l'ID du client
        List<Car> cars = repo.findByClientId(clientId);

        // Pour chaque voiture, définit les informations du client
        for (Car car : cars) {
            // Comme toutes les voitures appartiennent au même client, on utilise le même ID
            car.setClient(clientApi.findClientById(clientId));
        }
        return cars;
    }
}
