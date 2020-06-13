package Actors;

import java.util.ArrayList;
import java.util.List;

public class Azienda extends Utente{
	
	private String ragioneSociale;
	private String partitaIva;
	private String codiceFiscale;
	private String citta;
	private List<Conto> conti;

	public Azienda(String email, String password, String partitaIva, String codiceFiscale, String ragioneSociale, String citta) {
		super(email, password);
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.citta = citta;
		this.codiceFiscale = codiceFiscale;
		this.conti = new ArrayList<Conto>();
	}
}
