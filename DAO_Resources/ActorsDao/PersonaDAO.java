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
import Models.ContoModel;
import Models.PersonaModel;
import Models.UtenteModel;

public class PersonaDAO implements IPersonaDAO {

	@Override
	public void modificaInformazioniAccount(String nome, String cognome, String codiceFiscale, Date annoNascita,
			String password) {
		try (Statement stmt = conn.createStatement()) {

			String query = "UPDATE cliente SET NOME=?,COGNOME=?,CF=?,ANNO_DI_NASCITA=?,PASSWORD=? WHERE MAIL=?";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, codiceFiscale);
			ps.setDate(4, (java.sql.Date) annoNascita);
			ps.setString(5, password);

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
