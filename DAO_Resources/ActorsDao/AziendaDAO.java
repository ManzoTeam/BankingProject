package ActorsDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import IActorsDao.IAziendaDAO;

public class AziendaDAO implements IAziendaDAO{

	@Override
	public void modificaInformazioniAccount(String ragioneSociale, String codiceFiscale, String partitaIva,String citta) {
		try(Statement stmt =  conn.createStatement()) {
			
			String query="UPDATE Azienda SET RAGIONESOCIALE=?,PARTITAIVA=?,CF=?,CITTA=? WHERE MAIL=? ";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			
			ps.setString(1, ragioneSociale);
			ps.setString(2, partitaIva);
			ps.setString(3, codiceFiscale);
			ps.setString(4, citta);
			
		}catch (SQLException ex){
		// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
		
	}

}
