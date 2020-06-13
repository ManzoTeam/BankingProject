package IActors;

import java.util.Collection;

public interface ISistema extends IActors {
	
	public IAmministratore creaAmministratore(String mail, String password);
	
	public Collection<IAmministratore> getListaAdmin();
}
