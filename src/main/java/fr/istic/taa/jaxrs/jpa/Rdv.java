package fr.istic.taa.jaxrs.jpa;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Attributs de la classe Rdv
    private String date; // Date du rendez-vous
    private String heure; // Heure du rendez-vous

    @ManyToOne
    @XmlTransient

    private User client; // Client qui prend le rendez-vous

    @ManyToOne
    private User professionnel; // Professionnel qui prend le rendez-vous
    public Rdv() {
    }

    public Rdv(String date, String heure, User client, User professionnel) {
        this.date = date;
        this.heure = heure;
        this.client = client;
        this.professionnel = professionnel;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @XmlTransient
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @XmlTransient
    public User getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(User professionnel) {
        this.professionnel = professionnel;
    }

    // ToString pour affichage
    @Override
    public String toString() {
        return "Rdv [id=" + id + ", date=" + date + ", heure=" + heure + ", client=" + client + ", professionnel="
                + professionnel + "]";
    }
}
