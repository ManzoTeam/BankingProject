package IActorsDao;

import java.util.Collection;

public interface IContoDAO extends IActors {

	public Collection<IMovimentoDAO> getMovimenti(int numeroConto);
	
	public double getSaldo();
	
}
