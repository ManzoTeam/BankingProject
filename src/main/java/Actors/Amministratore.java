package Actors;

public abstract class Amministratore {
	
	private final int id;
	private String email;
	private String password;
	
	public Amministratore(String email, String password) {
		super();
		this.email=email;
		this.password=password;
		this.id=0;
		
	}
	
	public abstract boolean checkUserRegistration();
	
	public abstract boolean regAmministratore();
	
	public abstract Conto addContoCliente();
	
	public abstract Conto delContoCliente();
	
	public abstract Utente viewDati();

}
