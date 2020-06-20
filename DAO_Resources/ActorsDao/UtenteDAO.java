package ActorsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActorsDao.IContoDAO;
import IActorsDao.IUtenteDAO;
import Models.AziendaModel;
import Models.ContoModel;
import Models.UtenteModel;

public class UtenteDAO implements IUtenteDAO{

	@Override
	public boolean modificaEmail(String email) {
	try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET MAIL=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeQuery();
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
			ps.executeQuery();	
			
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
	public UtenteModel login(UtenteModel utente) {
		try (Statement stmt = conn.createStatement()) {
			String login;
			if(utente instanceof AziendaModel) {
				login = "select * from azienda where email=? and password=?";
			}else
				login = "select * from cliente where email=? and password=?";
			
			PreparedStatement ps = conn.prepareStatement(login);
			ps.setString(1, utente.email);
			ps.setString(2, utente.password);
			ps.executeQuery();
	
//			if (!rs.equals(null)) {
//				utente = new UtenteModel();
//			}
//			conn.close();
//			return utente;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Collection<ContoModel> visualizzaConti(UtenteModel utente) {
		ResultSet rs = null;
		
		try(Statement stmt =  conn.createStatement()) {
			String query;
			
			if(!(utente instanceof AziendaModel)) 
				query="SELECT * FROM conto WHERE PROPRIETARIO_AZIENDA=? ";
			else 
				query="SELECT * FROM conto WHERE PROPRIETARIO_PERSONA_FISICA=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1,utente.email);
			
			 rs=ps.executeQuery();
			 List<ContoModel> conti=new ArrayList<>();
			 
			 while(rs.next()) { 
					conti.add(new ContoModel(rs.getInt("NUMERO_CONTO"),rs.getDouble("SALDO"),utente,null));
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



}
