package Actors;

public class Azienda extends Utente{
	
	
	private String ragioneSociale;
	private String partitaIva;
	private String codiceFiscale;
	private String citta;

	public Azienda(String email, String password, String partitaIva, String codiceFiscale, String ragioneSociale,
			String citta) {
		super(email, password);
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.citta = citta;
		this.codiceFiscale = codiceFiscale;
	}
}
