package model.esame;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;

public class EsameBeanDao {

  /**
   * Metodo per salvare un esame.
   * @param eb esame da inserire
   * @return un intero per vedere se il salvataggio è andato a buon fine
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized int doSave(EsameBean eb) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;

      query = "INSERT INTO esame(CodiceEsame, Nome, CFU, OreLezione, Semestre,Descrizione) "
          + "values (?, ?, ?, ?, ?,?)";
      ps = conn.prepareStatement(query);

      ps.setInt(1, eb.getCodiceEsame());
      ps.setString(2, eb.getNome());
      ps.setInt(3, eb.getCfu());
      ps.setInt(4, eb.getOreLezione());
      ps.setString(5, eb.getSemestre());
      ps.setString(6, eb.getDescrizione());

      int i = ps.executeUpdate();
      if (i != 0) {
        return eb.getCodiceEsame();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0;
  }

  /**
   * Metodo per salvare/aggiornare un esame.
   * @param eb esame da inserire
   * @return un boolean per vedere se il salvataggio è andato a buon fine
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized boolean doSaveOrUpdate(EsameBean eb) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "UPDATE esame SET Nome=?, CFU=?, OreLezione=?, "
          + "Semestre=?, Descrizione = ? WHERE CodiceEsame=?";
      ps = conn.prepareStatement(query);

      ps.setString(1, eb.getNome());
      ps.setInt(2, eb.getCfu());
      ps.setInt(3, eb.getOreLezione());
      ps.setString(4, eb.getSemestre());
      ps.setString(5, eb.getDescrizione());
      ps.setInt(6, eb.getCodiceEsame());

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
   * Metodo che restituisce un esame dato il suo codice.
   * @param codiceEsame codice dell'esame
   * @return esame
   */
  public synchronized EsameBean doRetrieveByKey(int codiceEsame) {
    EsameBean eb = new EsameBean();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "SELECT * FROM esame WHERE CodiceEsame= ?";
      ps = conn.prepareStatement(query);
      ps.setInt(1, codiceEsame);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        eb.setCodiceEsame(codiceEsame);
        eb.setNome(items.getString("Nome"));
        eb.setCfu(items.getInt("CFU"));
        eb.setOreLezione(items.getInt("OreLezione"));
        eb.setSemestre(items.getString("Semestre"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return eb;
  }

  /**
   * Metodo che restituisce tutti gli esami.
   * @return lista di esami
   * @throws ClassNotFoundException eccezione lanciata quando la classe non corrisponde
   * @throws SQLException eccezione lanciata quando ci sono problemi con sql
   */
  public synchronized ArrayList<EsameBean> doRetriveAll() 
      throws ClassNotFoundException, SQLException {
    ArrayList<EsameBean> lista = new ArrayList<EsameBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "SELECT * FROM esame";

      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        EsameBean eb = new EsameBean();
        eb.setCodiceEsame(items.getInt("CodiceEsame"));
        eb.setNome(items.getString("Nome"));
        eb.setCfu(items.getInt("CFU"));
        eb.setOreLezione(items.getInt("OreLezione"));
        eb.setSemestre(items.getString("Semestre"));

        lista.add(eb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che cancella un esame.
   * @param codiceEsame codice dell'esame
   * @return un boolean per capire se la cancellazione è andata a buon fine
   * @throws IOException eccezione lanciata su I/O
   */
  public synchronized boolean doDelete(int codiceEsame) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "DELETE FROM esame WHERE CodiceEsame=?";

      ps = conn.prepareStatement(query);
      ps.setInt(1, codiceEsame);

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
   * Metodo che restituisce gli esami obbligatori di un offerta formativa 
   *              per un determinato curriculum.
   * @param anno  identificativo dell'offerta formativa
   * @param laurea identificativo  della laurea
   * @param curricula identificativo del curriculum
   * @param grOb identificativo di un gruppo obbligatorio
   * @return lista di esami
   * @throws ClassNotFoundException eccezione lanciata se la classe non corrisponde
   * @throws SQLException eccezione lanciata se c'e' un problema con sql
   */
  public synchronized ArrayList<EsameBean> doRetriveEsamiOffertaFormativaObb(
      String anno, int laurea, String curricula,
      int grOb) throws ClassNotFoundException, SQLException {
    
    ArrayList<EsameBean> lista = new ArrayList<EsameBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select e.nome, e.CFU, e.OreLezione, e.Semestre, e.CodiceEsame, e.Descrizione"
          + " from ((((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa"
          + " = c.AnnoOffertaFormativa ) join curriculum as cu \n"
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiobbligatori as "
          + "go on cu.IDCurriculum = go.Curriculum) join formazione as f \n"
          + " on go.CodiceGEOb = f.CodiceGEOb) join esame e on e.CodiceEsame = f.CodiceEsame\n"
          + " where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ? && go.CodiceGEOb = ?";

      ps = conn.prepareStatement(query);
      ps.setString(1, anno);
      ps.setInt(2, laurea);
      ps.setString(3, curricula);
      ps.setInt(4, grOb);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        EsameBean eb = new EsameBean();
        eb.setCodiceEsame(items.getInt("CodiceEsame"));
        eb.setNome(items.getString("Nome"));
        eb.setCfu(items.getInt("CFU"));
        eb.setOreLezione(items.getInt("OreLezione"));
        eb.setSemestre(items.getString("Semestre"));
        eb.setDescrizione(items.getString("Descrizione"));

        lista.add(eb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che restituisce gli esami opzionali di un offerta formativa 
   *              per un determinato curriculum.
   * @param anno  identificativo dell'offerta formativa
   * @param laurea identificativo  della laurea
   * @param curricula identificativo del curriculum
   * @param grOpz identificativo di un gruppo opzionale
   * @return lista di esami
   * @throws ClassNotFoundException eccezione lanciata se la classe non corrisponde
   * @throws SQLException eccezione lanciata se c'e' un problema con sql
   */
  public synchronized ArrayList<EsameBean> doRetriveEsamiOffertaFormativaOpz(
      String anno, int laurea, String curricula,
      int grOpz) throws ClassNotFoundException, SQLException {
    ArrayList<EsameBean> lista = new ArrayList<EsameBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select e.nome, e.CFU, e.OreLezione, e.Semestre, e.CodiceEsame, e.Descrizione"
          + " from ((((corsodilaurea as c join offertaformativa as o on o.AnnoOffertaFormativa"
          + " = c.AnnoOffertaFormativa ) join curriculum as cu \n"
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea) join gruppoesamiopzionali as "
          + "go on cu.IDCurriculum = go.IDCurriculum) join formato as f \n"
          + " on go.CodiceGEOp = f.CodiceGEOp) join esame e on e.CodiceEsame = f.CodiceEsame\n"
          + " where o.AnnoOffertaFormativa = ? && c.tipo = ? && cu.Nome = ? && go.CodiceGEOp = ?";

      ps = conn.prepareStatement(query);
      ps.setString(1, anno);
      ps.setInt(2, laurea);
      ps.setString(3, curricula);
      ps.setInt(4, grOpz);

      ResultSet items = ps.executeQuery();

      while (items.next()) {
        EsameBean eb = new EsameBean();
        eb.setCodiceEsame(items.getInt("CodiceEsame"));
        eb.setNome(items.getString("Nome"));
        eb.setCfu(items.getInt("CFU"));
        eb.setOreLezione(items.getInt("OreLezione"));
        eb.setSemestre(items.getString("Semestre"));
        eb.setDescrizione(items.getString("Descrizione"));

        lista.add(eb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  /**
   * Metodo che ritorna l'ultimo id di un esame.
   * @return l'ultimo id dell'esame presente nel db
   */
  public synchronized int doRetrieveLastId() {
    Connection conn = null;
    PreparedStatement ps = null;
    int codiceEsame = 0;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "SELECT max(CodiceEsame) AS massimoID FROM esame";
      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();

      items.next();
      codiceEsame = items.getInt("massimoID");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return codiceEsame;
  }
}
