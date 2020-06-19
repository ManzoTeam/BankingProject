package ActorsBL;

import java.util.Collection;
import java.util.List;

import IActorsBL.IConto;
import Models.MovimentoModel;
import Models.UtenteModel;

public class Conto implements IConto {
	
	private int numeroConto;
	private UtenteModel proprietario;
	private List<MovimentoModel> listaMovimento;
	
	public Conto(int numeroConto, UtenteModel proprietario, List<MovimentoModel> movimenti) {
		this.numeroConto = numeroConto;
		this.proprietario = proprietario;
		this.listaMovimento = movimenti;
	}
	
	public int getNumeroConto() {
		return numeroConto;
	}

	public UtenteModel getProprietario() {
		return proprietario;
	}

	public List<MovimentoModel> getListaMovimento() {
		return listaMovimento;
	}

	@Override
	public Collection<MovimentoModel> getMovimenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
