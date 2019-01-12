package model.docente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;

public class DocenteBeanDao {

  /**
   * Metodo per salvare un docente nel database.
   * @param db docente da salvare
   * @param codiceEsame codice esame per legare un esame ad un docente
   * @return un valore per capire se è stato salvato o meno
   * @throws IOException eccezione lanciata su problemi di I/0
   */
  public synchronized int doSave(DocenteBean db, int codiceEsame) throws IOException {
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
        query = "INSERT INTO insegnamento(CodiceDocente,CodiceEsame,classe) values (?,?,?)";
        ps = conn.prepareStatement(query);

        ps.setInt(1, db.getCodiceDocente());
        ps.setInt(2, codiceEsame);
        ps.setString(3, db.getInsegnamento());

        i = ps.executeUpdate();

        if (i != 0) {
          return 1;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * Metodo per inserire/aggiornare un docente.
   * @param db docente da salvare
   * @param codiceEsame codice esame per legare un esame ad un docente
   * @throws IOException eccezione lanciata su problemi di I/0
   */
  public synchronized void doSaveOrUpdate(DocenteBean db, int codiceEsame) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;
      query = "UPDATE docente SET Nome = ?, Cognome = ?,"
          + " IndirizzoPaginaWeb = ? WHERE CodiceDocente=?";

      ps = conn.prepareStatement(query);

      ps.setString(1, db.getNome());
      ps.setString(2, db.getCognome());
      ps.setString(3, db.getIndirizzoPaginaWeb());
      ps.setInt(4, db.getCodiceDocente());

      int y = ps.executeUpdate();

      if (y != 0) {
        query = "UPDATE insegnamento SET classe = ? WHERE CodiceDocente=? AND CodiceEsame=? ";
        
        ps = conn.prepareStatement(query);

        ps.setString(1, db.getInsegnamento());
        ps.setInt(2, db.getCodiceDocente());
        ps.setInt(3, codiceEsame);

        y = ps.executeUpdate();
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }

  /**
   * Metodo che restituisce un docente data una chiave.
   * @param codiceDocente id del docente
   * @return un docente
   */
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

  /**
   * Metodo che cancella un docente.
   * @param codiceDocente identificativo del docente
   * @return valore booleano per l'avvenuta cancellazione
   * @throws IOException eccezione lanciata se c'è un problema di I/O
   */
  public synchronized boolean doDelete(int codiceDocente) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "DELETE FROM docente WHERE CodiceDocente=?";

      ps = conn.prepareStatement(query);
      ps.setInt(1, codiceDocente);

      int i = ps.executeUpdate();
      if (i != 0) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Metodo che ritorna i docenti degli esami obbligatori.
   * @param anno identificativo dell'offerta formativa
   * @param laurea id della laurea
   * @param curricula ide del curricula
   * @param grOb id del gruppo obligatorio
   * @param nome identificativo dell'esame
   * @return lista di docenti
   */
  public synchronized ArrayList<DocenteBean> doRetrieveDocEsameObb(
      String anno, int laurea, String curricula, int grOb,String nome) {
    ArrayList<DocenteBean> list = new ArrayList<DocenteBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "select  d.nome, d.cognome, d.CodiceDocente, i.classe, d.IndirizzoPaginaWeb "
          + " from ((((((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa "
          + "= c.AnnoOffertaFormativa ) join curriculum as cu "
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori as go on "
          + "cu.IDCurriculum = go.Curriculum) join formazione as f "
          + " on go.CodiceGEOb = f.CodiceGEOb) join esame e on e.CodiceEsame"
          + " = f.CodiceEsame) join insegnamento i on e.CodiceEsame = i.CodiceEsame) "
          + "join docente d on d.CodiceDocente = i.CodiceDocente "
          + "where o.AnnoOffertaFormativa=? && c.tipo=? "
          + "&& cu.Nome=? && go.CodiceGEOb=? && e.Nome=?";

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

  /**
   * Metodo che ritorna i docenti degli esami opzionali.
   * @param anno identificativo dell'offerta formativa
   * @param laurea id della laurea
   * @param curricula ide del curricula
   * @param grOpz id del gruppo opzionale
   * @param nome identificativo dell'esame
   * @return lista di docenti
   */
  public synchronized ArrayList<DocenteBean> doRetrieveDocEsameOpz(
      String anno, int laurea, String curricula, int grOpz,
      String nome) {
    ArrayList<DocenteBean> list = new ArrayList<DocenteBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
     
      String query = "select d.nome, d.cognome, d.CodiceDocente, i.classe, d.IndirizzoPaginaWeb "
          + " from ((((((corsodilaurea as c join offertaformativa as "
          + "o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu "
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiopzionali "
          + "as go on cu.IDCurriculum = go.IDCurriculum) join formato as f "
          + " on go.CodiceGEOp = f.CodiceGEOp) join esame e on e.CodiceEsame = f.CodiceEsame)"
          + " join insegnamento i on e.CodiceEsame = i.CodiceEsame) "
          + "join docente d on d.CodiceDocente = i.CodiceDocente "
          + "where o.AnnoOffertaFormativa=? && c.tipo=? "
          + "&& cu.Nome=? && go.CodiceGEOp=? && e.Nome=?";
      
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

  /**
   * Metodo che ritorna l'ultimo id di un docente.
   * @return l'ultimo id inserito nel db
   */
  public synchronized int doRetrieveLastId() {
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
