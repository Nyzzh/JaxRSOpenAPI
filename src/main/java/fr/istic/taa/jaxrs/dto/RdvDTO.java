package fr.istic.taa.jaxrs.dto;

public class RdvDTO {
    private Long id;
    private String date;
    private String heure;
    private Long clientId;
    private Long professionnelId;

    public RdvDTO() {
    }

    public RdvDTO(Long id, String date, String heure, Long clientId, Long professionnelId) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.clientId = clientId;
        this.professionnelId = professionnelId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProfessionnelId() {
        return professionnelId;
    }

    public void setProfessionnelId(Long professionnelId) {
        this.professionnelId = professionnelId;
    }
}
