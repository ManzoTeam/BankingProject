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
		
		try(Statement stmt =  conn.createStatement()) {
			
			String query="INSERT INTO conto (NUMERO_CONTO,PROPRIETARIO_AZIENDA,PROPRIETARIO_PERSONA_FISICA,SALDO)"
						+ "values (?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1,numeroConto);
			ps.setDouble(4, saldo);
			if(!(proprietario instanceof Azienda))
				ps.setObject(2, proprietario);
			else
				ps.setObject(3, proprietario);
			
			this.numeroConto=numeroConto;
			this.saldo=saldo;
			this.proprietario=proprietario;
			listaMovimento=new ArrayList<>();
			
			ps.executeQuery();
			 
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
		
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
<<<<<<< HEAD
					listaMovimento.add(new Movimento(rs.getInt("ID_MOVIMENTO"),rs.getDouble("SOMMA_DENARO"),rs.getString("VERSAMENTO_PRELIEVO"),rs.getDate("DATA_MOVIMENTO")));
=======
					listaMovimento.add(new Movimento(rs.getInt("ID_MOVIMENTO"),rs.getDouble("SOMMA_DENARO")
							,rs.getString("VERSAMENTO_PRELIEVO"),rs.getDate("DATA_MOVIMENTO"),numeroConto));
>>>>>>> 1c1e598c9f32ec0c85a755af1f9d1755f9956ef3
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
		
		ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			
			String query="SELECT * FROM conto WHERE NUMERO_CONTO_MOVIMENTO=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1,numeroConto);
			
			rs=ps.executeQuery();
			 
		
		conn.close();
		return rs.getDouble("SALDO");
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return 0.0;
	}

	}
	
	

