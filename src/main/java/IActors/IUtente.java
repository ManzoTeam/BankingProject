package IActors;

import java.util.Collection;
import java.util.List;

import Actors.Conto;

import Actors.Utente;

public interface IUtente extends IActors {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
	public ISessione login();
	
	public void logout();
	
<<<<<<< HEAD
	public Collection<IConto> visualizzaConti(Utente utente);
=======
	public List<Conto> visualizzaConti();
>>>>>>> c8481ea1909bd1fb83ce03f210a03470062a5547
	
}
