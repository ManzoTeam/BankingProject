package IActors;

import java.util.Collection;


public interface ISistema {

	
	public IAmministratore creaAmministratore(String mail, String password);
	
	public Collection<IAmministratore> getListaAdmin();
}
