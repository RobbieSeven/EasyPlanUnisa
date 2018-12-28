package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorsoDiLaureaBeanDAO {

	public synchronized int doSave(CorsoDiLaureaBean cb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;

			query = "INSERT INTO corsodilaurea(IDCorsoDiLaurea, Tipo, AnnoOffertaFormativa) " + "values (?, ?, ?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, cb.getIdCorsoDiLaurea());
			ps.setInt(2, cb.isTipo());
			ps.setString(3, cb.getAnnoOffertaFormativa());

			int i = ps.executeUpdate();
			if (i != 0) {
				return cb.getIdCorsoDiLaurea();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public synchronized boolean doSaveOrUpdate(CorsoDiLaureaBean cb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;
			ResultSet result = ps.executeQuery("SELECT IDCorsoDiLaurea FROM corsodilaurea WHERE IDCorsoDiLaurea='"
					+ cb.getIdCorsoDiLaurea() + "'");

			if (result.next()) {
				query = "UPDATE corsodilaurea SET Tipo=?, AnnoOffertaFormativa=? WHERE IDCorsoDiLaurea=?";
				ps = conn.prepareStatement(query);

				ps.setInt(1, cb.isTipo());
				ps.setString(2, cb.getAnnoOffertaFormativa());
				ps.setInt(3, cb.getIdCorsoDiLaurea());

				int i = ps.executeUpdate();
				if (i != 0)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public synchronized CorsoDiLaureaBean doRetrieveByKey(int IdCorsoDiLaurea) {
		CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "SELECT * FROM corsodilaurea WHERE IDCorsoDiLaurea=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, IdCorsoDiLaurea);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				cb.setIdCorsoDiLaurea(IdCorsoDiLaurea);
				cb.setTipo(items.getInt("Tipo"));
				cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}

	public synchronized ArrayList<CorsoDiLaureaBean> doRetriveAll() throws ClassNotFoundException, SQLException {
		ArrayList<CorsoDiLaureaBean> lista = new ArrayList<CorsoDiLaureaBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "SELECT * FROM corsodilaurea";

			ps = conn.prepareStatement(query);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
				cb.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
				cb.setTipo(items.getInt("Tipo"));
				cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));

				lista.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public synchronized boolean doDelete(int IDCorsoDiLaurea) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "DELETE FROM corsodilaurea WHERE IDCorsoDiLaurea=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, IDCorsoDiLaurea);

			int i = ps.executeUpdate();
			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<CorsoDiLaureaBean> getCorsiLaureaOfferta(String nomeOfferta) {
		ArrayList<CorsoDiLaureaBean> lista = new ArrayList<CorsoDiLaureaBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "select c.Tipo, c.IDCorsoDiLaurea, c.AnnoOffertaFormativa" + 
					"	from corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa\n" + 
					"		where o.AnnoOffertaFormativa = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, nomeOfferta);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				CorsoDiLaureaBean cb = new CorsoDiLaureaBean();
				cb.setIdCorsoDiLaurea(items.getInt("IDCorsoDiLaurea"));
				cb.setTipo(items.getInt("Tipo"));
				cb.setAnnoOffertaFormativa(items.getString("AnnoOffertaFormativa"));

				lista.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}
