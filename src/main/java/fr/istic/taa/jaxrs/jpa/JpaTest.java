package fr.istic.taa.jaxrs.jpa;

import fr.istic.taa.jaxrs.dao.*;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaTest {
	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		ClientDAO clientDAO = new ClientDAO();
		ProDAO proDAO = new ProDAO(manager);
		RdvDAO rdvDAO = new RdvDAO(manager);
		try {
			test.createUsersAndRdvs(clientDAO,proDAO,rdvDAO); // Crée des utilisateurs (clients et professionnels) et des rendez-vous
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.listUsersAndRdvs(); // Liste les utilisateurs et les rendez-vous
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

	private void createUsersAndRdvs(ClientDAO clientDAO, ProDAO proDAO, RdvDAO rdvDAO) {
		// Création d'utilisateurs (clients et professionnels)
		Client client1 = new Client("Client1", "client1@email.com", "Adresse1", "123456789");
		Client client2 = new Client("Client2", "client2@email.com", "Adresse2", "987654321");
		Pro pro1 = new Pro("Pro1", "pro1@email.com", "Entreprise1", "Spécialité1");

		clientDAO.createClient(client1);
		clientDAO.createClient(client2);
		proDAO.createPro(pro1);

		// Création de rendez-vous
		Rdv rdv1 = new Rdv("2023-09-15", "10:00", client1, pro1);
		Rdv rdv2 = new Rdv("2023-09-16", "14:00", client2, pro1);

		rdvDAO.createRdv(rdv1);
		rdvDAO.createRdv(rdv2);
	}
	private void listUsersAndRdvs() {
		List<User> users = manager.createQuery("Select u From User u", User.class).getResultList();
		List<Rdv> rdvs = manager.createQuery("Select r From Rdv r", Rdv.class).getResultList();

		System.out.println("num of users:" + users.size());
		for (User user : users) {
			System.out.println("next user: " + user);
		}

		System.out.println("num of rdvs:" + rdvs.size());
		for (Rdv rdv : rdvs) {
			System.out.println("next rdv: " + rdv);
		}
	}
}