package IActorsBL;

import java.util.Collection;

import Models.AmministratoreModel;

public interface ISistema {

	public AmministratoreModel creaAmministratore(String mail, String password);
	public Collection<AmministratoreModel> getListaAdmin();
}
