package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public synchronized ArrayList<DocenteBean> doRetrieveDocEsameObb(String anno, int laurea, String curricula,int grOb, String nome) {
		ArrayList<DocenteBean> list = new ArrayList<DocenteBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "select  d.nome, d.cognome, d.CodiceDocente, i.classe, d.IndirizzoPaginaWeb " +
					" from ((((((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu " +
					" on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori as go on cu.IDCurriculum = go.Curriculum) join formazione as f " +
					" on go.CodiceGEOb = f.CodiceGEOb) join esame e on e.CodiceEsame = f.CodiceEsame) join insegnamento i on e.CodiceEsame = i.CodiceEsame) " +
					"join docente d on d.CodiceDocente = i.CodiceDocente " +
					"where o.AnnoOffertaFormativa=? && c.tipo=? && cu.Nome=? && go.CodiceGEOb=? && e.Nome=?";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, anno);
			ps.setInt(2, laurea);
			ps.setString(3, curricula);
			ps.setInt(4, grOb);
			ps.setString(5, nome);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				DocenteBean db = new DocenteBean();
				db.setCodiceDocente(items.getInt("CodiceDocente"));
				db.setNome(items.getString("Nome"));
				db.setCognome(items.getString("Cognome"));
				db.setIndirizzoPaginaWeb(items.getString("IndirizzoPaginaWeb"));
				db.setInsegnamento(items.getString("classe"));
				
				list.add(db);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public synchronized ArrayList<DocenteBean> doRetrieveDocEsameOpz(String anno, int laurea, String curricula,int grOpz, String nome) {
		ArrayList<DocenteBean> list = new ArrayList<DocenteBean>();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			/*
			String query = "select d.Nome, d.Cognome, d.CodiceDocente, ins.classe, d.IndirizzoPaginaWeb " + 
					" from (((((((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu " + 
					" on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiopzionali as go on cu.IDCurriculum = go.IDCurriculum) join formato as f " + 
					" on go.CodiceGEOp = f.CodiceGEOp) join esame e on e.CodiceEsame = f.CodiceEsame) join insegnamento i on e.CodiceEsame = i.CodiceEsame) " + 
					" join docente d on d.CodiceDocente = i.CodiceDocente) join insegnamento as ins on ins.CodiceEsame = e.CodiceEsame " + 
					" where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ? && go.CodiceGEOp = ? && e.Nome = ?";
			*/
			String query = "select d.nome, d.cognome, d.CodiceDocente, i.classe, d.IndirizzoPaginaWeb " +
					" from ((((((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu " +
					" on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiopzionali as go on cu.IDCurriculum = go.IDCurriculum) join formato as f " +
					" on go.CodiceGEOp = f.CodiceGEOp) join esame e on e.CodiceEsame = f.CodiceEsame) join insegnamento i on e.CodiceEsame = i.CodiceEsame) " +
					"join docente d on d.CodiceDocente = i.CodiceDocente " +
					"where o.AnnoOffertaFormativa=? && c.tipo=? && cu.Nome=? && go.CodiceGEOp=? && e.Nome=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, anno);
			ps.setInt(2, laurea);
			ps.setString(3, curricula);
			ps.setInt(4, grOpz);
			ps.setString(5, nome);

			ResultSet items = ps.executeQuery();

			while (items.next()) {
				DocenteBean db = new DocenteBean();
				db.setCodiceDocente(items.getInt("CodiceDocente"));
				db.setNome(items.getString("Nome"));
				db.setCognome(items.getString("Cognome"));
				db.setIndirizzoPaginaWeb(items.getString("IndirizzoPaginaWeb"));
				db.setInsegnamento(items.getString("classe"));
				
				list.add(db);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public synchronized int doRetrieveLastID() {
		Connection conn = null;
		PreparedStatement ps = null;
		int codiceDocente = 0;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			String query = "SELECT max(CodiceDocente) AS massimoID FROM docente";
			ps = conn.prepareStatement(query);

			ResultSet items = ps.executeQuery();

			items.next();
			codiceDocente = items.getInt("massimoID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codiceDocente;
	}
}
