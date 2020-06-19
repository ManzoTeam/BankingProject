package ActorsDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import IActorsDao.IAmministratoreDAO;
import IActorsDao.IContoDAO;
import IActorsDao.IUtenteDAO;
import Models.AziendaModel;
import Models.UtenteModel;

public class AmministratoreDAO implements IAmministratoreDAO{

	@Override
	public boolean modificaEmail(String email_da_modificare, String nuova_email) {

		try (Statement stmt = conn.createStatement()) {

			String query = "update amministratore set email=? where email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, nuova_email);
			ps.setString(2, email_da_modificare);
			ps.executeQuery();

			return true; 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificaPassword(String email, String new_password) {
		try (Statement stmt = conn.createStatement()) {

			String query = "update amministratore set password_admin=? where email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(2, new_password);
			ps.setString(1, email);
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void creaUtente(UtenteModel utente) {
		try (Statement stmt = conn.createStatement()) {
			
			String query;
			PreparedStatement ps;
			
			if(utente instanceof AziendaModel) { 
				query="insert into azienda(mail,password_a) values (?,?) ";
				ps=conn.prepareStatement(query);
				ps.setString(1,utente.email);
				ps.setString(2, utente.password);
				}
			else {
				query="insert into cliente(mail,password_a) values (?,?) ";
				ps=conn.prepareStatement(query);
				ps.setString(1,utente.email);
				ps.setString(2, utente.password);
				
			}
			
			ps.executeQuery();
		}	

		 catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Collection<UtenteModel> getElenco() {
		try (Statement stmt = conn.createStatement()) {

			String elencoAzienda = "select * from azienda";
			String elencoUtente = "select * from cliente";

			PreparedStatement ps = conn.prepareStatement(elencoAzienda);
			PreparedStatement ps1 = conn.prepareStatement(elencoUtente);

			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();

			List<IUtenteDAO> lista = new ArrayList<>();

			while (rs.next() || rs1.next()) {
				AziendaModel azienda = new AziendaModel(rs.getString("mail"), rs.getString("password"));
				UtenteModel utente = new UtenteModel(rs.getString("email"), rs.getString("password"));
				lista.add(azienda);
				lista.add(utente);
			}
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean login(String email, String password) {
		try (Statement stmt = conn.createStatement()) {

			String login = "select * from amministratore where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (!rs.equals(null))
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void creaConto(int numeroConto, IUtenteDAO utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean cancellaConto(int numeroConto) {
		try (Statement stmt = conn.createStatement()) {

			String cercaConto = "select * from conto where numero_conto=?";
			PreparedStatement ps = conn.prepareStatement(cercaConto);
			ps.setInt(1, numeroConto);
			ResultSet rs = ps.executeQuery();

			if (!rs.equals(null)) {
				String cancellaConto = "delete from conto where numero_conto=?";
				ps = conn.prepareStatement(cancellaConto);
				ps.setInt(1, numeroConto);
				ps.executeQuery();
				System.out.println("Cancellazione conto riuscita.");
				
//				stmt.close();
				return true;
			}
			
//			stmt.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void creaAmministratore(String mail, String password) {
		// TODO Auto-generated method stub
		
	}

}
