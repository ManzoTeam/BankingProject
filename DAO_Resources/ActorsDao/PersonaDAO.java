package ActorsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import IActorsDao.IContoDAO;
import IActorsDao.IPersonaDAO;
import Models.PersonaModel;

public class PersonaDAO implements IPersonaDAO{

	@Override
	public boolean modificaEmail(String email) {
		
			try (Statement stmt = conn.createStatement()) {

				String query = "update cliente set email=? where email=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, email);
				ps.executeQuery();

				return true; 
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		}
		
	
	@Override
	public boolean modificaPassword(String password) {
		try (Statement stmt = conn.createStatement()) {

			String query = "update cliente set password_admin=? where email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, password);
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Utente login(String email, String password) {
		try (Statement stmt = conn.createStatement()) {

			String login = "select * from amministratore where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Utente utente=null;
			if (!rs.equals(null)) {
				utente = new Utente();
			}
				
			conn.close();
			return utente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void logout() {
//		
//	}

	@Override
	public Collection<IContoDAO> visualizzaConti(Utente utente) {
		try(Statement stmt = conn.createStatement()){
			
			String query = "select * from cliente where conto=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			List<IContoDAO> listaConti = new ArrayList<>();
			
			while(rs.next()) {
				//TODO VisualizzareConti
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modificaInformazioniAccount(String nome, String cognome, String codiceFiscale, Date annoNascita,
			String password) {
		try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE cliente SET NOME=?,COGNOME=?,CF=?,ANNO_DI_NASCITA=?,PASSWORD=? WHERE MAIL=?";
			
			PreparedStatement ps=conn.prepareStatement(query);

			ps.setString(1,nome);
			ps.setString(2, cognome);
			ps.setString(3, codiceFiscale);
			ps.setDate(4, (java.sql.Date) annoNascita);
			ps.setString(5, password);

			
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
		
	}
		
	}

