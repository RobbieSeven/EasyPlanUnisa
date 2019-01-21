package model.gruppo.esami;

import java.util.ArrayList;

import model.esame.EsameBean;

public class GruppoEsamiOpzionaliBean {

  // VARIABILI D'ISTANZA
  private int codiceGeOp;
  private int anno;
  private int totCfu;
  private int idCurriculum;
  private ArrayList<EsameBean> esami;

  // COSTRUTTORI
  public GruppoEsamiOpzionaliBean() {}

  /**
   * Metodo costruttore con parametri.
   * @param codiceGeOp codice del gruppo obbligatorio
   * @param anno anno del gruppo
   * @param idCurriculum id del curricula a cui appartiene
   * @param esami lista di esami sel gruppo
   */
  public GruppoEsamiOpzionaliBean(int codiceGeOp, int anno, int totCfu,
      int idCurriculum, ArrayList<EsameBean> esami) {
    this.codiceGeOp = codiceGeOp;
    this.anno = anno;
    this.totCfu = totCfu;
    this.idCurriculum = idCurriculum;
    this.esami = esami;
  }

  // GETTER E SETTER
  public int getCodiceGeOp() {
    return codiceGeOp;
  }

  public void setCodiceGeOp(int codiceGeOp) {
    this.codiceGeOp = codiceGeOp;
  }

  public int getAnno() {
    return anno;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  public int getTotCfu() {
    return totCfu;
  }

  public void setTotCfu(int totCfu) {
    this.totCfu = totCfu;
  }

  public int getIdCurriculum() {
    return idCurriculum;
  }

  public void setIdCurriculum(int idCurriculum) {
    this.idCurriculum = idCurriculum;
  }

  public ArrayList<EsameBean> getEsami() {
    return esami;
  }

  public void setEsami(ArrayList<EsameBean> esami) {
    this.esami = esami;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "GruppoEsamiOpzionali [codiceGEOp=" + codiceGeOp 
        + ", anno=" + anno + ", totCFU=" + totCfu
        + ", idCurriculum=" + idCurriculum + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + anno;
    result = prime * result + codiceGeOp;
    result = prime * result + ((esami == null) ? 0 : esami.hashCode());
    result = prime * result + idCurriculum;
    result = prime * result + totCfu;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GruppoEsamiOpzionaliBean other = (GruppoEsamiOpzionaliBean) obj;
    if (anno != other.anno)
      return false;
    if (codiceGeOp != other.codiceGeOp)
      return false;
    if (esami == null) {
      if (other.esami != null)
        return false;
    } else if (!esami.equals(other.esami))
      return false;
    if (idCurriculum != other.idCurriculum)
      return false;
    if (totCfu != other.totCfu)
      return false;
    return true;
  }
  
  
}
