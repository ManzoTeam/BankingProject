package ActorsDao;

import java.util.Collection;
import java.util.Date;

import IActorsDao.IContoDAO;
import IActorsDao.IPersonaDAO;

public class PersonaDAO implements IPersonaDAO{

	@Override
	public boolean modificaEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utente login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<IContoDAO> visualizzaConti(Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificaInformazioniAccount(String nome, String cognome, String codiceFiscale, Date annoNascita,
			String password) {
		// TODO Auto-generated method stub
		
	}

}
