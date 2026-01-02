package com.example.car.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour l'entité Car
 *
 * Ces tests vérifient le bon fonctionnement des getters, setters
 * et constructeurs de l'entité Car.
 *
 * @author Hamza Aglagal
 * @version 1.0
 * @since 2025
 */
class CarTest {

    /**
     * Test du constructeur par défaut
     */
    @Test
    void testDefaultConstructor() {
        Car car = new Car();

        assertNotNull(car);
        assertNull(car.getId());
        assertNull(car.getMarque());
        assertNull(car.getModele());
        assertNull(car.getClientId());
        assertNull(car.getClient());
    }

    /**
     * Test du constructeur paramétré
     */
    @Test
    void testParameterizedConstructor() {
        Long id = 1L;
        String marque = "Toyota";
        String modele = "Corolla";
        Long clientId = 100L;

        Car car = new Car(id, marque, modele, clientId);

        assertEquals(id, car.getId());
        assertEquals(marque, car.getMarque());
        assertEquals(modele, car.getModele());
        assertEquals(clientId, car.getClientId());
    }

    /**
     * Test des setters et getters pour l'identifiant
     */
    @Test
    void testIdSetterGetter() {
        Car car = new Car();
        Long id = 123L;

        car.setId(id);
        assertEquals(id, car.getId());
    }

    /**
     * Test des setters et getters pour la marque
     */
    @Test
    void testMarqueSetterGetter() {
        Car car = new Car();
        String marque = "BMW";

        car.setMarque(marque);
        assertEquals(marque, car.getMarque());
    }

    /**
     * Test des setters et getters pour le modèle
     */
    @Test
    void testModeleSetterGetter() {
        Car car = new Car();
        String modele = "X5";

        car.setModele(modele);
        assertEquals(modele, car.getModele());
    }

    /**
     * Test des setters et getters pour l'identifiant du client
     */
    @Test
    void testClientIdSetterGetter() {
        Car car = new Car();
        Long clientId = 456L;

        car.setClientId(clientId);
        assertEquals(clientId, car.getClientId());
    }

    /**
     * Test des setters et getters pour l'instance du client
     */
    @Test
    void testClientSetterGetter() {
        Car car = new Car();
        Client client = new Client();
        client.setId(1L);
        client.setNom("John Doe");
        client.setAge(30.0f);

        car.setClient(client);
        assertEquals(client, car.getClient());
    }
}