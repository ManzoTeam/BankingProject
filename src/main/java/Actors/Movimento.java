package Actors;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.xdevapi.Result;
import IActors.IMovimento;
import java.util.Date;
import IActors.IMovimento;

public class Movimento implements IMovimento {

	private int id;
	private double sommaDenaro;
	private String tipo;
	private Date dataMovimento;
	
	public Movimento(int id,double sommaDenaro,String tipo,Date dataMovimento,int numeroConto) {
		/*try(Statement stmt =  conn.createStatement()) {
			
			String query="INSERT INTO conto (ID_MOVIMENTO,NUMERO_CONTO_MOVIMENTO,SOMMA_DENARO,VERSAMENTE_PRELIEVO,DATA_MOVIMENTO)"
						+ "values (?,?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1,id);
			ps.setInt(2, numeroConto);
			ps.setDouble(3,sommaDenaro );
			ps.setString(4, tipo);
			ps.setDate(5, (java.sql.Date) dataMovimento);
			
			
			
			ps.executeQuery();
			 
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	*/
		
		this.id=id;
		this.sommaDenaro=sommaDenaro;
		this.tipo=tipo;
		this.dataMovimento=dataMovimento;
	}

	@Override
	public double getSommaMovimento() {

		ResultSet rs = null;

		try (Statement stmt = conn.createStatement()) {

			String query = "SELECT SOMMA_DENARO FROM movimenti WHERE ID_MOVIMENTO=? ";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			conn.close();
			
			return rs.getDouble("SOMMA_DENARO");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return 0.0;
	}

	@Override
	public String getTipoMovimento() {
	ResultSet rs = null;
			
			try(Statement stmt =  conn.createStatement()) {
				
				String query="SELECT * FROM movimenti WHERE ID_MOVIMENTO=? ";
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				ps.setInt(1,id);
				
				rs=ps.executeQuery();
				 
				conn.close();
			    return rs.getString("VERSAMENTO_PRELIEVO");
			}catch (SQLException ex){
			// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
			
			
			return null;
	}




}