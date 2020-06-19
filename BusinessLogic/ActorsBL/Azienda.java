package ActorsBL;

import java.util.List;

import IActorsBL.IAzienda;
import Models.ContoModel;

public class Azienda extends Utente implements IAzienda{

	public String ragioneSociale;
	public String partitaIva;
	public String codiceFiscale;
	public String citta;
	public List<ContoModel> conti;
	
	public Azienda(String email, String password, String ragioneSociale, String partitaIva, String codiceFiscale, String citta, List<ContoModel> conti) {
		super(email, password);
		this.ragioneSociale=ragioneSociale;
		this.partitaIva=partitaIva;
		this.codiceFiscale=codiceFiscale;
		this.citta=citta;
		this.conti = conti;
	}
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getCitta() {
		return citta;
	}

	public List<ContoModel> getConti() {
		return conti;
	}

	@Override
	public void modificaInformazioniAccount(String ragioneSociale, String codiceFiscale, String partitaIva,
			String citta) {
		// TODO Auto-generated method stub
		
	}

}
