package IActors;

import java.util.Collection;
import java.util.List;

import Actors.Conto;

import Actors.Utente;

public interface IUtente extends IActors {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
<<<<<<< HEAD
	public Utente login();
	
=======
	public ISessione login(String email,String password);
	
	public void logout();
>>>>>>> 1d8c428e988a3e79d5764988dcf85be25e02d9e3

	public Collection<IConto> visualizzaConti(Utente utente);

	

	
}
