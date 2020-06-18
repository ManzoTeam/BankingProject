package IActors;

import java.util.Date;

public interface IPersona extends IUtente, IActors {

	public void modificaInformazioniAccount(String nome, String cognome,String codiceFiscale,Date annoNascita,String password);
		
}
