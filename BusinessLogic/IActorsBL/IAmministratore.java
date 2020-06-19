package IActorsBL;

import java.util.Collection;
import IActorsDao.IUtenteDAO;
import Models.UtenteModel;

public interface IAmministratore {

	public boolean modificaEmail();
	
	public boolean modificaPassword();
	
	public void creaUtente(String email_utente, String password_utente);
	
	public Collection<UtenteModel> getElenco();
	
	public boolean login();
	
	public void creaConto(int numeroConto, String email_utente, String password_utente);
	
	public boolean cancellaConto(int numeroConto);
	
	public void creaAmministratore(String mail, String password);
	
}
