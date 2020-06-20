package IActorsDao;

import java.util.Date;

public interface IPersonaDAO extends IActors {

	public void modificaInformazioniAccount(String nome, String cognome,String codiceFiscale,Date annoNascita,String password);
		
}
