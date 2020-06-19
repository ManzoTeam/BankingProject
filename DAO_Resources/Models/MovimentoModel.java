package Models;

import java.util.Date;

public class MovimentoModel {

	public int id;
	public double sommaDenaro;
	public String tipo;
	public Date dataMovimento;
	
	public MovimentoModel(int id, double sommaDenaro, String tipo, Date data) {
		this.id = id;
		this.sommaDenaro = sommaDenaro;
		this.tipo = tipo;
		this.dataMovimento = data;
	}
}
