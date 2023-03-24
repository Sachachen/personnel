package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import personnel.*;

class testEmploye 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void estAdminTrue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
	@Test
	void estAdminFalse() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertFalse(employe.estAdmin(ligue));
	}
	
	@Test
	void estRootTrue() throws SauvegardeImpossible
	{
		Employe root = gestionPersonnel.getRoot();
		assertTrue(root.estRoot());
	}
	
	@Test
	void estRootFalse() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertFalse(employe.estRoot());
	}
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		assertEquals("Bouchard", employe.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		employe.setNom("Chen");
		assertEquals("Chen", employe.getNom());
	}
	
	@Test
	void setPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		employe.setPrenom("Namakan");
		assertEquals("Namakan", employe.getPrenom());
	}
	
	@Test
	void getPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals("Gérard", employe.getPrenom());
	}
	
	@Test
	void setMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		employe.setMail("co@gmail.com");
		assertEquals("co@gmail.com", employe.getMail());
	}
	
	@Test
	void getMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals("g.bouchard@gmail.com", employe.getMail());
	}
	
	@Test
	void setPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		employe.setPassword("0000");
		assertTrue(employe.checkPassword("0000"));
	}
	
	@Test
	void checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertTrue(employe.checkPassword("azerty"));
	}
	
	@Test
	void remove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}
	
	@Test
	void removeAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}
	
	@Test
	void removeRoot() throws SauvegardeImpossible
	{
		Employe root = gestionPersonnel.getRoot();
		assertThrows(ImpossibleDeSupprimerRoot.class, () ->root.remove());
	}
	
	@Test
	void setDateD() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		employe.setDateD(2023,12,11);
		LocalDate date = LocalDate.of(2023, 12, 11);
		assertEquals(date, employe.getDateD());
	}
	
	@Test
	void setDateA() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		employe.setDateA(2022,12,10);
		LocalDate date = LocalDate.of(2022, 12, 10);
		assertEquals(date, employe.getDateA());
	}
}
