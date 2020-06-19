package IActorsDao;

public interface IAziendaDAO extends IActors {
	
	public void modificaInformazioniAccount(String ragioneSociale,String codiceFiscale,String partitaIva,String citta);

}
