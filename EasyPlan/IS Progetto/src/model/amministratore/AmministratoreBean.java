package model.amministratore;

public class AmministratoreBean {

  // variabili d'istanza
  private String username;
  private String password;

  /**
   * Metodo costruttore vuoto.
   */
  public AmministratoreBean() {}

  /**
   * Costruttore con parametri.
   * @param username username dell'amministratore
   * @param password password dell'amministratore
   */
  public AmministratoreBean(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // GETTER E SETTER
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "AmministratoreBean [username=" + username + ", password=" + password + "]";
  }
}
