package Actors;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

import IActors.IMovimento;

public class Movimento implements IMovimento {

	private int id;
	private int numeroConto;
	private double sommaDenaro;
	private String tipo;
	
	public Movimento() {
		
	}

	@Override
	public double getSommaMovimento(){
		Result rs = null;
		try (Statement stmt = conn.createStatement() ) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
	}

	@Override
	public String getTipoMovimento() {
		// TODO Auto-generated method stub
		return null;
	}
}
