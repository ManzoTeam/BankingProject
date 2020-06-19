package IActorsDao;

import java.util.Collection;

public interface ISistemaDAO extends IActors {
	
	public IAmministratoreDAO creaAmministratore(String mail, String password);
	
	public Collection<IAmministratoreDAO> getListaAdmin();
}
