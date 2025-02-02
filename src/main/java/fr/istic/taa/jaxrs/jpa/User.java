package fr.istic.taa.jaxrs.jpa;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@Entity
@XmlRootElement

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    // On met d'autre attribut ? genre nom prenom etc ?

    @OneToMany(mappedBy = "client")
    private List<Rdv> rdvsEnTantQueClient;

    @OneToMany(mappedBy = "professionnel")
    private List<Rdv> rdvsEnTantQueProfessionnel;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters et setters

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //ici on sépare prendre des rendez vous en tant que client et en tant que professionel car une même personne peut à
    //la fois être professionel et prendre un rendez vous.
    public List<Rdv> getRdvsEnTantQueClient() {
        return rdvsEnTantQueClient;
    }

    public void setRdvsEnTantQueClient(List<Rdv> rdvsEnTantQueClient) {
        this.rdvsEnTantQueClient = rdvsEnTantQueClient;
    }

    public List<Rdv> getRdvsEnTantQueProfessionnel() {
        return rdvsEnTantQueProfessionnel;
    }

    public void setRdvsEnTantQueProfessionnel(List<Rdv> rdvsEnTantQueProfessionnel) {
        this.rdvsEnTantQueProfessionnel = rdvsEnTantQueProfessionnel;
    }

    // ToString pour affichage
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }
}
