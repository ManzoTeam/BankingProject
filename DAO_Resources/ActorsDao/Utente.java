package ActorsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActorsDao.IContoDAO;
import IActorsDao.ISessioneDAO;
import IActorsDao.IUtenteDAO;

public class Utente implements IUtenteDAO{
		
	public boolean modificaEmail(String email) {
		try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET MAIL=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, email);
			ps.setString(2, this.email);
			
			this.email=email;
			
			
			return true;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		return false;
	}

	@Override
	public boolean modificaPassword(String password) {
		try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET PASSWORD_A=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, password);
			ps.setString(2, email);
			
			this.password=password;
			
			
			return true;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		return false;
	}

	@Override
	public Utente login() {		
		try (Statement stmt = conn.createStatement()) {
			String login;
			if(this instanceof Azienda) {
				login = "select * from azienda where email=? and password=?";
			}else
				login = "select * from cliente where email=? and password=?";
			
			PreparedStatement ps = conn.prepareStatement(login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Utente utente = null;
			if (!rs.equals(null)) {
				utente = new Utente();
				utente.setEmail(email);
			}
			conn.close();
			return utente;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//Logout utente dirammente nella servlet --> come con amministratore

	@Override
	public Collection<IContoDAO> visualizzaConti(Utente utente) {
		
		ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			String query;
			
			if(!(utente instanceof Azienda)) 
				query="SELECT * FROM conto WHERE PROPRIETARIO_AZIENDA=? ";
			else 
				query="SELECT * FROM conto WHERE PROPRIETARIO_PERSONA_FISICA=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1,email);
			
			 rs=ps.executeQuery();
			 List<IContoDAO> conti=new ArrayList<>();
			 
			 while(rs.next()) { 
					conti.add(new Conto(rs.getInt("NUMERO_CONTO"),rs.getDouble("SALDO"),utente));
					}
			 conn.close();
			 return conti;
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return null;
	}

	@Override
	public void logout() {
		
		
	}

	@Override
	public Utente login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
