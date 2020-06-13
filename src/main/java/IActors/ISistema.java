package IActors;

public interface ISistema {

	public IUtente creaUtente(String mail, String password, Object... params);
	public IAmministratore creaAmministratore(String mail, String password);
}
