package Models;

import java.util.ArrayList;
import java.util.List;

public class ContoModel {

	public int numeroConto;
	public double saldo;
	public UtenteModel proprietario;
	public List<MovimentoModel> listaMovimento;
	
	public ContoModel(int numeroConto, UtenteModel proprietario) {
			this(numeroConto, 0.0, proprietario,new ArrayList<MovimentoModel>());
	}

	public ContoModel(int numeroConto, double saldo, UtenteModel proprietario,List<MovimentoModel>listaMovimento) {
		this.numeroConto=numeroConto;
		this.saldo=saldo;
		this.proprietario=proprietario;
		this.listaMovimento=listaMovimento;
	}
}
