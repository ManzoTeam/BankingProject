package IActorsDao;

import java.util.Collection;
import java.util.List;

import Models.ContoModel;
import Models.UtenteModel;

public interface IUtenteDAO extends IActors {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
	public UtenteModel login(UtenteModel utente);

//	public void logout();

	public Collection<ContoModel> visualizzaConti(UtenteModel utente);
	
}
