package IActors;

import java.util.Collection;

public interface IUtente extends IActors {

	public boolean modificaEmail(String email);
	
	public boolean modificaPassword(String password);
	
	public ISessione login();
	
	public void logout();
	
	public Collection<IConto> visualizzaConti();
	
}
