package IActors;

import java.util.Collection;

import Actors.Amministratore;


public interface IAmministratore extends IActors {

	public boolean modificaEmail();
	
	public boolean modificaPassword();
	
	public IUtente creaUtente(String email, String password, Object... params);
	
	public Collection<IUtente> getElenco();
	
	public Amministratore login(String email, String password);
	
	public IConto creaConto(int numeroConto,IUtente utente);
	
	public boolean cancellaConto(int numeroConto);
	
	public IAmministratore creaAmministratore(String mail, String password);
}
