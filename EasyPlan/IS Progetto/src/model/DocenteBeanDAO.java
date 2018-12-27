package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocenteBeanDAO {

	// Funzione per inserire un docente nel database
	public synchronized int doSave(DocenteBean db) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;

			query = "INSERT INTO docente(CodiceDocente,Nome,Cognome,IndirizzoPaginaWeb) values (?,?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, db.getCodiceDocente());
			ps.setString(2, db.getNome());
			ps.setString(3, db.getCognome());
			ps.setString(4, db.getIndirizzoPaginaWeb());

			int i = ps.executeUpdate();
			if (i != 0) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Funzione per ricercare un docente dalla chiave
	public synchronized DocenteBean doRetrieveByKey(int codiceDocente) {
		DocenteBean db = new DocenteBean();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "SELECT * FROM docente WHERE CodiceDocente= ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, codiceDocente);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				db.setCodiceDocente(codiceDocente);
				db.setNome(items.getString("Nome"));
				db.setCognome(items.getString("Cognome"));
				db.setIndirizzoPaginaWeb(items.getString("IndirizzoPaginaWeb"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return db;
	}

	// funzione per eliminare un docente data la chiave
	public synchronized boolean doDelete(int codiceDocente) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "DELETE FROM docente WHERE CodiceDocente=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, codiceDocente);

			int i = ps.executeUpdate();
			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
