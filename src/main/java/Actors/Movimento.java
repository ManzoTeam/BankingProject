package Actors;

import java.util.Date;

import IActors.IMovimento;

public class Movimento implements IMovimento{

	private int id;
	private double sommaDenaro;
	private String tipo;
	private Date dataMovimento;
	
	public Movimento(int id,double sommaDenaro,String tipo,Date dataMovimento) {
		this.id=id;
		this.sommaDenaro=sommaDenaro;
		this.tipo=tipo;
		this.dataMovimento=dataMovimento;
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
