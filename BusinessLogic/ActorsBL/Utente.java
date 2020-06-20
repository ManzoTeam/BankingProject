package ActorsBL;

import java.util.Collection;

import IActorsBL.IUtente;
import Models.ContoModel;

public class Utente implements IUtente {

	private String email; 
	private String password;
	
	public Utente(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

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
	public void login() {
		// TODO Auto-generated method stub
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<ContoModel> visualizzaConti(ActorsDao.Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}


}
