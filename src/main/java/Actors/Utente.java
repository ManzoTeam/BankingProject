package Actors;

public class Utente {
	
	
	private String email; // Chiave primaria
	private String password;
	
	public Utente() {

	}

	public Utente(String email, String password) {
		// Controlli Email, Password
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public Utente getUtente() {
		return this;
	}
}
