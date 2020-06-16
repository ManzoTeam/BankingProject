package Actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActors.IConto;
import IActors.IMovimento;


public class Conto implements IConto{

	private int numeroConto;
	private double saldo;
	private Utente proprietario;
	private List<IMovimento> listaMovimento;
	
	public Conto(int numeroConto,double saldo,Utente proprietario) {
		this.numeroConto=numeroConto;
		this.saldo=saldo;
		this.proprietario=proprietario;
		listaMovimento=new ArrayList<>();
	}

	@Override
	public Collection<IMovimento> getMovimenti() {
		ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			
			String query="SELECT * FROM movimenti WHERE NUMERO_CONTO_MOVIMENTO=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1,numeroConto);
			
			 rs=ps.executeQuery();
			 
			 while(rs.next()) { 
					listaMovimento.add(new Movimento(rs.getInt("ID_MOVIMENTO"),rs.getDouble("SOMMA_DENARO"),rs.getString("VERSAMENTO_PRELIEVO"),rs.getDate("DATA_MOVIMENTO")));
					}
		conn.close();
		return listaMovimento;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return null;
	}

	@Override
	public double getSaldo() {
		
		return 0;
	}
	
	
}
