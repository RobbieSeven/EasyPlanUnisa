package model.curriculum;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;

public class CurriculumBeanDao {

  /**
   * Metodo per creare un nuovo curricula.
   * @param cb curriculum da salvare
   * @return un intero per controllare se il salvataggio è avvenuto
   * @throws IOException lancia l'eccezione se c'è un problema con l'input/output
   */
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

  /**
   * Metodo per salvare o aggiornare un curricula in caso che già esista.
   * @param cb curricula da inserire/aggiornare
   * @return un booleano per controllare se il salvataggio/aggiornamento è avvenuto
   * @throws IOException lancia l'eccezione se c'è un problema con l'input/output
   */
  @SuppressWarnings("null")
  public synchronized boolean doSaveOrUpdate(CurriculumBean cb) throws IOException {

    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = null;
      ResultSet result = ps
          .executeQuery("SELECT IDCurriculum FROM curriculum WHERE IDCurriculum='" 
              + cb.getIdCurriculum() + "'");

      if (result.next()) {
        query = "UPDATE curriculum SET IDCurriculum=?,Nome=?,"
            + "IDCorsoDiLaurea=? WHERE IDCurriculum=?";
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

  /**
   * Metodo che restituisce un curriculum data la chiave.
   * @param idCurriculum id del curriculum
   * @return il curriculum cercato
   */
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

  /**
   * Metodo per cancellare un curriculum data la sua chiave.
   * @param idCurriculum id del curriculum
   * @return valore booleano per la conferma di avvenuta cancellazione
   * @throws IOException eccezione lanciata se c'e' un problema di I/O
   */
  public synchronized boolean doDelete(int idCurriculum) throws IOException {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "DELETE FROM curriculum WHERE IDCurriculum=?";

      ps = conn.prepareStatement(query);
      ps.setInt(1, idCurriculum);

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
   * Metodo che restituisce tutti i curricula.
   * @return  restituisce una lista di curricula
   * @throws ClassNotFoundException lanciata se la classe non viene trovata
   * @throws SQLException lanciata se c'è un errore legato al database
   */
  public synchronized ArrayList<CurriculumBean> doRetriveByAll() 
      throws ClassNotFoundException, SQLException {

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

  /**
   * Metodo che restituisce i curriculum di un corso di laurea di un offerta formativa.
   * @param laurea id della laurea
   * @param anno id dell'offerta formativa
   * @return una lista di curriculum
   * @throws ClassNotFoundException lanciata se la classe non viene trovata
   * @throws SQLException lanciata se c'è un errore legato al database
   */
  public synchronized ArrayList<CurriculumBean> doRetriveByCorsoDiLaureaOffertaFormativa(
      int laurea, String anno)throws ClassNotFoundException, SQLException {

    ArrayList<CurriculumBean> lista = new ArrayList<CurriculumBean>();
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();
      String query = "select * from (corsodilaurea as c join offertaformativa "
          + "as o on o.AnnoOffertaFormativa = c.AnnoOffertaFormativa ) join curriculum as cu \r\n"
          + " on c.IDcorsodilaurea = cu.IDcorsodilaurea " 
          + " where o.AnnoOffertaFormativa ='" + anno
          + "' && c.tipo =" + laurea + ";";

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

  /**
   * Metodo che ritorna l'id maggiore dei curricula.
   * @return l'id maggiore
   */
  public synchronized int doRetrieveByIdMaggiore() {

    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = DriverManagerConnectionPool.getConnection();

      String query = "select c.IDCurriculum " + "from curriculum c " 
          + "order by c.IDCurriculum DESC";
      ps = conn.prepareStatement(query);

      ResultSet items = ps.executeQuery();
      int c;
      items.next();
      c = items.getInt("IDCurriculum");
      return c + 1;

    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }

  }

}
