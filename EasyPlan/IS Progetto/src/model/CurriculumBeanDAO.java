package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CurriculumBeanDAO {

	// Funzione per inserire un curriculum nel database
	public synchronized int doSave(CurriculumBean cb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;

			query = "INSERT INTO curriculum(IDCurriculum,Nome,IDCorsoDiLaurea) values (?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, cb.getIdCurriculum());
			ps.setString(2, cb.getNomeCurriculum());
			ps.setInt(3, cb.getIdCorsoDiLaurea());

			int i = ps.executeUpdate();
			if (i != 0) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Funzione per salvare e modificare un curriculum esistente
	public synchronized boolean doSaveOrUpdate(CurriculumBean cb) throws IOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;
			ResultSet result = ps.executeQuery(
					"SELECT IDCurriculum FROM curriculum WHERE IDCurriculum='" + cb.getIdCurriculum() + "'");

			if (result.next()) {
				query = "UPDATE curriculum SET IDCurriculum=?,Nome=?,IDCorsoDiLaurea=? WHERE IDCurriculum=?";
				ps = conn.prepareStatement(query);

				ps.setInt(1, cb.getIdCurriculum());
				ps.setString(2, cb.getNomeCurriculum());
				ps.setInt(3, cb.getIdCorsoDiLaurea());

				int i = ps.executeUpdate();
				if (i != 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Funzione per ricercare un curriculum data la sua chiave
	public synchronized CurriculumBean doRetrieveByKey(int idCurriculum) {
		CurriculumBean cb = new CurriculumBean();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "SELECT * FROM curriculum WHERE IDCurriculum= ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, idCurriculum);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				cb.setIdCurriculum(idCurriculum);
				cb.setNomeCurriculum(items.getString("Nome"));
				cb.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}

	// Funzione per eliminare un curriculum data la sua chiave
	public synchronized boolean doDelete(int idCurriculum) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "DELETE FROM curriculum WHERE IDCurriculum=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, idCurriculum);

			int i = ps.executeUpdate();
			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Funzione per selezionare tutti i curricula
	public synchronized ArrayList<CurriculumBean> doRetriveByAll() throws ClassNotFoundException, SQLException {

		ArrayList<CurriculumBean> lista = new ArrayList<CurriculumBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "SELECT * FROM curriculum";

			ps = conn.prepareStatement(query);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				CurriculumBean cb = new CurriculumBean();
				cb.setIdCurriculum(items.getInt("IDCurriculum"));
				cb.setNomeCurriculum(items.getString("Nome"));
				cb.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
				lista.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
