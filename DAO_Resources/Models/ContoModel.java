package Models;

import java.util.List;

public class ContoModel {

	public int numeroConto;
	public double saldo;
	public UtenteModel proprietario;
	public List<MovimentoModel> listaMovimento;
	
	public ContoModel(int numeroConto, double saldo, UtenteModel proprietario, List<MovimentoModel> movimenti) {
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.proprietario = proprietario;
		this.listaMovimento = movimenti;
	}
}
