package Models;

import java.util.ArrayList;
import java.util.List;

public class AziendaModel extends UtenteModel {
	
	public String ragioneSociale;
	public String partitaIva;
	public String codiceFiscale;
	public String citta;
	public List<ContoModel> conti;
	
	public AziendaModel(String email, String password, String ragioneSociale, String partitaIva, String codiceFiscale, String citta, List<ContoModel> conti) {
		super(email, password);
		this.ragioneSociale=ragioneSociale;
		this.partitaIva=partitaIva;
		this.codiceFiscale=codiceFiscale;
		this.citta=citta;
		this.conti = conti;
	}
	
}
