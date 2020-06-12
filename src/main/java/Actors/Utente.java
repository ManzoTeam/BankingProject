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
}
