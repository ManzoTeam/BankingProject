package IActors;

import java.util.Collection;

import Actors.Amministratore;
import Actors.Utente;


public interface IAmministratore extends IActors {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
	public IUtente creaUtente(Utente utente);
	
	public Collection<IUtente> getElenco();
	
	public Amministratore login(String email, String password);
	
	public IConto creaConto(int numeroConto,IUtente utente);
	
	public boolean cancellaConto(int numeroConto);
	
	public IAmministratore creaAmministratore(String mail, String password);
}
