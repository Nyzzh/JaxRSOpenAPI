package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import fr.istic.taa.jaxrs.jpa.*;

//Classe DAO pour la classe Rendez-Vous
public class RdvDAO {
    private EntityManager entityManager;

    public RdvDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createRdv(Rdv rdv) {
        entityManager.getTransaction().begin();
        entityManager.persist(rdv);
        entityManager.getTransaction().commit();
    }

    public void updateRdv(Rdv rdv) {
        entityManager.getTransaction().begin();
        entityManager.merge(rdv);
        entityManager.getTransaction().commit();
    }

    public void deleteRdv(Rdv rdv) {
        entityManager.getTransaction().begin();
        entityManager.remove(rdv);
        entityManager.getTransaction().commit();
    }

    public Rdv getRdvById(Long rdvId) {
        return entityManager.find(Rdv.class, rdvId);
    }
}