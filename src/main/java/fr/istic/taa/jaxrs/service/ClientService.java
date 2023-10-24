package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.ClientDAO;
import fr.istic.taa.jaxrs.jpa.Client;

public class ClientService {

    public Client getClientById(Long clientId){
        ClientDAO clientDAO = new ClientDAO();
        return clientDAO.getClientById(clientId);
    }

}
