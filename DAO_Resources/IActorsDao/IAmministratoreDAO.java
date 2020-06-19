package IActorsDao;

import java.util.Collection;


import ActorsDao.Utente;
import Models.UtenteModel;


	public interface IAmministratoreDAO extends IActors {

	public boolean modificaEmail(String email_da_modificare, String nuova_email);
	
	public boolean modificaPassword(String email, String new_password);
	
	public void creaUtente(UtenteModel utente);
	
	public Collection<UtenteModel> getElenco();
	
	public boolean login(String email, String password);
	
	public void creaConto(int numeroConto,IUtenteDAO utente);
	
	public boolean cancellaConto(int numeroConto);
	
	public void creaAmministratore(String mail, String password);
}
