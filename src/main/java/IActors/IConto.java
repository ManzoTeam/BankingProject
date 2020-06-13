package IActors;

import java.util.Collection;

public interface IConto extends IActors {

	public Collection<IMovimento> getMovimenti();
	
	public double getSaldo();
	
}
