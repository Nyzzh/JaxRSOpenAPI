package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Pet;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import fr.istic.taa.jaxrs.jpa.*;
import fr.istic.taa.jaxrs.dao.*;

@Path("/client")
@Produces({"application/json", "application/xml"})
public class ClientRessource {

    EntityManager manager = EntityManagerHelper.getEntityManager();

    ClientDAO clientDAO = new ClientDAO(manager);

    @GET
    @Path("/{clientId}")
    public Client getClientById(@PathParam("clientId") Long clientId) { // Remplace userId par clientId
        // Récupérer un client par son ID
        return clientDAO.getClientById(clientId); // Remplace userDAO par clientDAO
    }

    @GET
    @Path("/")
    public Pet getPet(Long petId)  {
        return new Pet();
    }


    @POST
    @Consumes("application/json")
    public Response addPet(
            @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}