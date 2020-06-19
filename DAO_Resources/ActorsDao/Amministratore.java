//package ActorsDao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import IActorsDao.IAmministratoreDAO;
//import IActorsDao.IContoDAO;
//import IActorsDao.ISessioneDAO;
//import IActorsDao.IUtenteDAO;
//import Models.UtenteModel;
//
//public class Amministratore implements IAmministratoreDAO {
//
//
//	@Override
//	public boolean cancellaConto(int numeroConto) {
//		
//	}
//
//	@Override
//	public Amministratore login(String email, String password) {
//		try (Statement stmt = conn.createStatement()) {
//
//			String login = "select * from amministratore where email=? and password=?";
//			PreparedStatement ps = conn.prepareStatement(login);
//			ps.setString(1, email);
//			ps.setString(2, password);
//			ResultSet rs = ps.executeQuery();
//			Amministratore amm = null;
//			if (!rs.equals(null)) {
//				amm = new Amministratore();
//				amm.setEmail(email);
//			}
//			conn.close();
//			return amm;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	@Override
//	public Collection<IUtenteDAO> getElenco() {
//
//		try (Statement stmt = conn.createStatement()) {
//
//			String elencoAzienda = "select * from azienda";
//			String elencoUtente = "select * from cliente";
//
//			PreparedStatement ps = conn.prepareStatement(elencoAzienda);
//			PreparedStatement ps1 = conn.prepareStatement(elencoUtente);
//
//			ResultSet rs = ps.executeQuery();
//			ResultSet rs1 = ps1.executeQuery();
//
//			List<IUtenteDAO> lista = new ArrayList<>();
//
//			while (rs.next() || rs1.next()) {
//				Azienda azienda = new Azienda(rs.getString("mail"), rs.getString("password"));
//				Utente utente = new Utente(rs.getString("email"), rs.getString("password"));
//				lista.add(azienda);
//				lista.add(utente);
//			}
//			conn.close();
//			return lista;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	@Override
//	public IContoDAO creaConto(int numeroConto, IUtenteDAO utente) {
//		try (Statement stmt = conn.createStatement()) {
//			String query;
//			String query1;
//			if(utente instanceof Azienda) {
//				query= "select count(proprietario_azienda) as num_conto from conto where proprietario_azienda<?";
//				query1="insert into conto(numero_conto,proprietario_azienda)values(?,?)";
//			}
//			else {
//				query= "select count(proprietario_persona_fisica) as num_conto from conto where proprietario_persona_fisica<?";
//				query1="insert into conto(numero_conto,proprietario_persona_fisica)values(?,?)";
//			}
//
//			 
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, ((Utente) utente).getEmail());
//			ps.setInt(2, NUMERO_MAX_CONTI);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.equals(null)) 
//				return null;
//
//			
//			ps=conn.prepareStatement(query1);
//			if(utente instanceof Azienda) {
//				ps.setInt(1, numeroConto);
//				ps.setString(2,((Azienda) utente).getEmail());
//			}
//			else {
//				ps.setInt(1, numeroConto);
//				ps.setString(2,((Azienda) utente).getEmail());
//			}
//			
//			ps.executeQuery(query1);
//			return new Conto(numeroConto,((Azienda)utente));
//
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public IAmministratoreDAO creaAmministratore(String mail, String password) {
//		
//		try (Statement stmt = conn.createStatement()) {
//			
//			String query="insert into amministratore(mail,password_a) values (?,?) ";
//			PreparedStatement ps=conn.prepareStatement(query);
//			ps.setString(1,email);
//			ps.setString(2,password);
//				
//			ps.executeQuery();
//			
//			return new Amministratore(email,password);
//		}	
//
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	@Override
//	public boolean modificaEmail(String email_da_modificare, String nuova_email) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean modificaPassword(String email, String new_password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void creaUtente(UtenteModel utente) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean login(String email, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void creaConto(int numeroConto, IUtenteDAO utente) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void creaAmministratore(String mail, String password) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//}
