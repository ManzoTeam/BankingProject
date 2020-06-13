package IActors;

import java.util.Collection;


public interface IAmministratore {

	public boolean modificaEmail();
	
	public boolean modificaPassword();
	
	public IUtente creaUtente(String mail, String password, Object... params);
	
	public Collection<IUtente> getElenco();
	
	public ISessione login();
	
	public void logout();
	
	public IConto creaConto(int numeroConto,IUtente utente);
	
	public boolean cancellaConto(int numeroConto);
	
	public IAmministratore creaAmministratore(String mail, String password);
}
