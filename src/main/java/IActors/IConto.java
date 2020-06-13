package IActors;

import java.util.Collection;

public interface IConto {

	public Collection<IMovimento> getMovimenti();
	
	public double getSaldo();
	
}
