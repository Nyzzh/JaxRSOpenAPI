package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import fr.istic.taa.jaxrs.jpa.*;

import java.util.List;

public class ClientDAO {

    private EntityManager entityManager =  EntityManagerHelper.getEntityManager();

    public void createClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    public void updateClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
    }

    public void deleteClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }

    public Client getClientById(Long clientId) {
        return entityManager.find(Client.class, clientId);
    }

    public List<Client> getAllClients() {
        Query query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }
}