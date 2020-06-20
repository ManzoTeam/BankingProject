package ActorsBL;

import java.util.Collection;

import IActorsBL.IAmministratore;
import Models.UtenteModel;

public class Amministratore implements IAmministratore{
	
	private final int id;
	private String email;
	private String password;

	public Amministratore(int id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean modificaEmail() {
		return false;
	}

	@Override
	public boolean modificaPassword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creaUtente(String email_utente, String password_utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<UtenteModel> getElenco() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creaConto(int numeroConto, String email_utente, String password_utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean cancellaConto(int numeroConto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void creaAmministratore(String mail, String password) {
		// TODO Auto-generated method stub
		
	}

}
