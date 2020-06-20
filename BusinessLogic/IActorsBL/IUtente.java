package IActorsBL;

import java.util.Collection;

import ActorsBL.Utente;
import Models.ContoModel;

public interface IUtente {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
	public void login();

	public void logout();

	public Collection<ContoModel> visualizzaConti(Utente utente);
	
}
