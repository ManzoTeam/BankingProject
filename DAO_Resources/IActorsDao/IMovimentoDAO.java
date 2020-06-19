package IActorsDao;

public interface IMovimentoDAO extends IActors {

	public double getSommaMovimento(int id);
	
	public String getTipoMovimento(int id);
}
