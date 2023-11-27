package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import fr.istic.taa.jaxrs.jpa.*;

import java.util.List;

//Classe DAO pour la classe Client
public class ClientDAO extends AbstractJpaDao<Integer, Client> {

    private EntityManager entityManager =  EntityManagerHelper.getEntityManager();

    public void createClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    public Client updateClient(Long clientId, Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
        return client;
    }

    public boolean deleteClient(Long client) {
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
        return false;
    }

    public Client getClientById(Long clientId) {
        return entityManager.find(Client.class, clientId);
    }

    public List<Client> getAllClients() {
        Query query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    public Client addClient(Client client) {
        return client;
    }
}