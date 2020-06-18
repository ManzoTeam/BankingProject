package IActors;

import Actors.Azienda;

public interface IAzienda extends IActors {
	
	public void modificaInformazioniAccount(String ragioneSociale,String codiceFiscale,String partitaIva,String citta);

}
