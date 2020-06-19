package IActorsDao;

import java.util.Collection;
import java.util.List;

import ActorsDao.Conto;
import ActorsDao.Utente;

public interface IUtenteDAO extends IActors {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
	public Utente login();

	public void logout();

	public Collection<IContoDAO> visualizzaConti(Utente utente);
	
}
