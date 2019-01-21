package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {

  private static List<Connection> freeDbConnections;

  static {
    freeDbConnections = new LinkedList<Connection>();
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("DB driver not found:" + e.getMessage());
    }
  }

  private static synchronized Connection createDbConnection() throws SQLException {
    Connection newConnection = null;
    String ip = "localhost";
    String port = "3306";
    String db = "easyplan";
    String username = "easyplan";
    String password = "project";

    newConnection = DriverManager.getConnection(
        "jdbc:mysql://" + ip + ":" + port + "/" + db, username, password);

    newConnection.setAutoCommit(true);
    return newConnection;
  }

  /**
   * Metodo che restituisce una connessione per il db.
   * @return una connessione al database
   * @throws SQLException eccezione legata ad un problema sql
   */
  public static synchronized Connection getConnection() throws SQLException {
    Connection connection;

    if (!freeDbConnections.isEmpty()) {
      connection = (Connection) freeDbConnections.get(0);
      freeDbConnections.remove(0);

      try {
        if (connection.isClosed()) {
          connection = getConnection();
        }
      } catch (SQLException e) {
        connection.close();
        connection = getConnection();
      }
    } else {
      connection = createDbConnection();
    }

    return connection;
  }

  /**
   * Metodo che rilascia una connessione se non utilizzata.
   * @param connection prende una connessione
   * @throws SQLException eccezione legata ad un problema sql
   */
  public static synchronized void releaseConnection(Connection connection) throws SQLException {
    if (connection != null) {
      freeDbConnections.add(connection);
    }
  }

}
