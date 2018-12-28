package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GruppoEsamiObbligatoriBeanDAO {

	// Funzione per salvare un gruppo d'esami obbligatori
	public synchronized int doSave(GruppoEsamiObbligatoriBean gb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;

			query = "INSERT INTO gruppoesamiobbligatori(CodiceGEOb,Anno,Curriculum) " + "values (?, ?, ?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, gb.getCodiceGEOb());
			ps.setInt(2, gb.getAnno());
			ps.setInt(3, gb.getIdCurriculum());

			int i = ps.executeUpdate();
			if (i != 0) {
				return gb.getIdCurriculum();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Funzione per modificare e salvare un gruppo d'esami obbligatori
	public synchronized boolean doSaveOrUpdate(GruppoEsamiObbligatoriBean gb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = null;
			ResultSet result = ps.executeQuery(
					"SELECT CodiceGEOb FROM gruppoesamiobbligatori WHERE CodiceGEOb='" + gb.getCodiceGEOb() + "'");

			if (result.next()) {
				query = "UPDATE gruppoesamiobbligatori SET Anno=?,Curriculum=? WHERE CodiceGEOb=?";
				ps = conn.prepareStatement(query);

				ps.setInt(1, gb.getAnno());
				ps.setInt(2, gb.getIdCurriculum());
				ps.setInt(3, gb.getCodiceGEOb());

				int i = ps.executeUpdate();
				if (i != 0)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// Funzione per trovare gruppo d'esami obbligatori data la sua chiave
	public synchronized GruppoEsamiObbligatoriBean doRetrieveByKey(int codiceGEOb) {
		GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "SELECT * FROM gruppoesamiobbligatori WHERE CodiceGEOb= ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, codiceGEOb);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				gb.setCodiceGEOb(codiceGEOb);
				gb.setAnno(items.getInt("Anno"));
				gb.setIdCurriculum(items.getInt("Curriculum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gb;
	}

	// Funzione per trovare tutti i gruppi d'esami obbligatori
	public synchronized ArrayList<GruppoEsamiObbligatoriBean> doRetriveAll()
			throws ClassNotFoundException, SQLException {
		ArrayList<GruppoEsamiObbligatoriBean> lista = new ArrayList<GruppoEsamiObbligatoriBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "SELECT * FROM gruppoesamiobbligatori";

			ps = conn.prepareStatement(query);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
				gb.setAnno(items.getInt("Anno"));
				gb.setCodiceGEOb(items.getInt("CodiceGEOb"));
				gb.setIdCurriculum(items.getInt("Curriculum"));
				lista.add(gb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	// Funzione per eliminare un gruppo d'esami obbligatori dato il suo codice
	public synchronized boolean doDelete(int codiceGEOb) throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "DELETE FROM gruppoesamiobbligatori WHERE CodiceGEOb=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, codiceGEOb);

			int i = ps.executeUpdate();
			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public synchronized ArrayList<GruppoEsamiObbligatoriBean> doRetriveGruppoEsamiObbByOfferta(String anno, int laurea, String curricula)
			throws ClassNotFoundException, SQLException {
		ArrayList<GruppoEsamiObbligatoriBean> lista = new ArrayList<GruppoEsamiObbligatoriBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "select go.CodiceGEOb, go.Anno, go.Curriculum" + 
					"	from ((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu \n" + 
					"			on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori as go on cu.IDCurriculum = go.Curriculum\n" + 
					"	where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, anno);
			ps.setInt(2, laurea);
			ps.setString(3, curricula);
			
			
			ResultSet items = ps.executeQuery();

			while (items.next()) {
				GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
				gb.setAnno(items.getInt("Anno"));
				gb.setCodiceGEOb(items.getInt("CodiceGEOb"));
				gb.setIdCurriculum(items.getInt("Curriculum"));
				lista.add(gb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public synchronized ArrayList<GruppoEsamiObbligatoriBean> doRetriveGruppoEsamiObbByOffertaAndAnno(String offertaForm, int laurea, String curricula, int anno)
			throws ClassNotFoundException, SQLException {
		ArrayList<GruppoEsamiObbligatoriBean> lista = new ArrayList<GruppoEsamiObbligatoriBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			String query = "select go.CodiceGEOb, go.Anno, go.Curriculum" + 
					"	from ((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu \n" + 
					"			on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori as go on cu.IDCurriculum = go.Curriculum\n" + 
					"	where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ? && go.anno = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, offertaForm);
			ps.setInt(2, laurea);
			ps.setString(3, curricula);
			ps.setInt(4, anno);
			
			
			ResultSet items = ps.executeQuery();

			while (items.next()) {
				GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
				gb.setAnno(items.getInt("Anno"));
				gb.setCodiceGEOb(items.getInt("CodiceGEOb"));
				gb.setIdCurriculum(items.getInt("Curriculum"));
				lista.add(gb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}
