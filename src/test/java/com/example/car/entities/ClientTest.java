package com.example.car.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour l'entité Client (dans le service voiture)
 *
 * Ces tests vérifient le bon fonctionnement des getters, setters
 * et constructeurs de l'entité Client utilisée pour l'enrichissement.
 *
 * @author Hamza Aglagal
 * @version 1.0
 * @since 2025
 */
class ClientTest {

    /**
     * Test du constructeur par défaut
     */
    @Test
    void testDefaultConstructor() {
        Client client = new Client();

        assertNotNull(client);
        assertNull(client.getId());
        assertNull(client.getNom());
        assertNull(client.getAge());
    }

    /**
     * Test des setters et getters pour l'identifiant
     */
    @Test
    void testIdSetterGetter() {
        Client client = new Client();
        Long id = 1L;

        client.setId(id);
        assertEquals(id, client.getId());
    }

    /**
     * Test des setters et getters pour le nom
     */
    @Test
    void testNomSetterGetter() {
        Client client = new Client();
        String nom = "Alice Dupont";

        client.setNom(nom);
        assertEquals(nom, client.getNom());
    }

    /**
     * Test des setters et getters pour l'âge
     */
    @Test
    void testAgeSetterGetter() {
        Client client = new Client();
        Float age = 25.5f;

        client.setAge(age);
        assertEquals(age, client.getAge());
    }

    /**
     * Test des valeurs limites pour l'âge
     */
    @Test
    void testAgeBoundaryValues() {
        Client client = new Client();

        // Test avec zéro
        client.setAge(0.0f);
        assertEquals(0.0f, client.getAge());

        // Test avec une valeur négative (bien que non réaliste)
        client.setAge(-5.0f);
        assertEquals(-5.0f, client.getAge());

        // Test avec une valeur élevée
        client.setAge(150.0f);
        assertEquals(150.0f, client.getAge());
    }
}