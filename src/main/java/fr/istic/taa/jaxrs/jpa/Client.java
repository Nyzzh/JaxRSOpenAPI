package fr.istic.taa.jaxrs.jpa;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@XmlRootElement
public class Client extends User implements Serializable {
    private String adresse;
    private String numeroTelephone;

    // Attributs spécifiques aux Clients ??

    public Client() {

    }

    public Client(String username, String email, String adresse, String numeroTelephone) {
        super(username, email);
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
    }

    @XmlElement(name = "adress")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    // ToString pour affichage
    @Override
    public String toString() {
        return "Client [id=" + getId() + ", username=" + getUsername() + ", email=" + getEmail()
                + ", adresse=" + adresse + ", numeroTelephone=" + numeroTelephone + "]";
    }
}
