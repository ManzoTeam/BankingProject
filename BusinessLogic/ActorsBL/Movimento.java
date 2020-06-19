package ActorsBL;

import java.util.Date;

import IActorsBL.IMovimento;

public class Movimento implements IMovimento {
	
	private int id;
	private double sommaDenaro;
	private String tipo;
	private Date dataMovimento;
	
	public Movimento(int id, double sommaDenaro, String tipo, Date data) {
		this.id = id;
		this.sommaDenaro = sommaDenaro;
		this.tipo = tipo;
		this.dataMovimento = data;
	}

	public int getId() {
		return id;
	}

	public double getSommaDenaro() {
		return sommaDenaro;
	}

	public String getTipo() {
		return tipo;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	@Override
	public double getSommaMovimento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTipoMovimento() {
		// TODO Auto-generated method stub
		return null;
	}

}
