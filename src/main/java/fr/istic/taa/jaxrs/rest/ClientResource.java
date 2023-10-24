package fr.istic.taa.jaxrs.rest;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import fr.istic.taa.jaxrs.jpa.*;
import fr.istic.taa.jaxrs.dao.*;

@Path("/client") // Modifie le chemin vers /client
@Produces({"application/json", "application/xml"})
public class ClientResource { // Modifie la classe UserResource en ClientResource

  EntityManager manager = EntityManagerHelper.getEntityManager();

  ClientDAO clientDAO = new ClientDAO(manager); // Remplace UserDAO par ClientDAO

  @GET
  @Path("/{clientId}") // Modifie userId en clientId
  public Client getClientById(@PathParam("clientId") Long clientId) { // Remplace userId par clientId
    // Récupérer un client par son ID
    return clientDAO.getClientById(clientId); // Remplace userDAO par clientDAO
  }

  @POST
  @Consumes("application/json")
  public Response addClient( // Remplace addUser par addClient
                             @Parameter(description = "Client object that needs to be added to the store", required = true) Client client) { // Remplace User par Client
    // Ajouter un client
    Client addedClient = clientDAO.addClient(client); // Remplace userDAO par clientDAO

    if (addedClient != null) {
      // Le client a été ajouté avec succès. Vous pouvez renvoyer un code de réponse 201 (Created).
      return Response.status(Response.Status.CREATED).entity(addedClient).build();
    } else {
      // Si quelque chose ne s'est pas bien passé lors de l'ajout du client, renvoyez un code d'erreur.
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Impossible d'ajouter le client.").build();
    }
  }

  @PUT
  @Path("/{clientId}") // Modifie userId en clientId
  @Consumes("application/json")
  public Response updateClient( // Remplace updateUser par updateClient
                                @PathParam("clientId") Long clientId, // Remplace userId par clientId
                                @Parameter(description = "Updated client object", required = true) Client updatedClient) { // Remplace User par Client
    // Mettre à jour un client existant
    Client updated = clientDAO.updateClient(clientId, updatedClient); // Remplace userDAO par clientDAO

    if (updated != null) {
      // Le client a été mis à jour avec succès. Vous pouvez renvoyer un code de réponse 200 (OK).
      return Response.ok().entity(updated).build();
    } else {
      // Si quelque chose ne s'est pas bien passé lors de la mise à jour du client, renvoyez un code d'erreur.
      return Response.status(Response.Status.NOT_FOUND).entity("Client non trouvé.").build();
    }
  }

  @DELETE
  @Path("/{clientId}") // Modifie userId en clientId
  public Response deleteClient(@PathParam("clientId") Long clientId) { // Remplace userId par clientId
    // Supprimer un client par son ID
    boolean deleted = clientDAO.deleteClient(clientId); // Remplace userDAO par clientDAO

    if (deleted) {
      // Le client a été supprimé avec succès. Vous pouvez renvoyer un code de réponse 204 (No Content).
      return Response.noContent().build();
    } else {
      // Si quelque chose ne s'est pas bien passé lors de la suppression du client, renvoyez un code d'erreur.
      return Response.status(Response.Status.NOT_FOUND).entity("Client non trouvé.").build();
    }
  }
}
