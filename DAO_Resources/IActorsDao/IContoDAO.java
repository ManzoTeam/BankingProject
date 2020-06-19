package IActorsDao;

import java.util.Collection;

public interface IContoDAO extends IActors {

	public Collection<IMovimentoDAO> getMovimenti();
	
	public double getSaldo();
	
}
