package model.curriculum;

import java.util.ArrayList;

import model.gruppo.esami.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBean;

public class CurriculumBean {

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((gruppiObbligatori == null) ? 0 : gruppiObbligatori.hashCode());
    result = prime * result + ((gruppiOpzionali == null) ? 0 : gruppiOpzionali.hashCode());
    result = prime * result + idCorsoDiLaurea;
    result = prime * result + idCurriculum;
    result = prime * result + ((nomeCurriculum == null) ? 0 : nomeCurriculum.hashCode());
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
    CurriculumBean other = (CurriculumBean) obj;
    if (gruppiObbligatori == null) {
      if (other.gruppiObbligatori != null)
        return false;
    } else if (!gruppiObbligatori.equals(other.gruppiObbligatori))
      return false;
    if (gruppiOpzionali == null) {
      if (other.gruppiOpzionali != null)
        return false;
    } else if (!gruppiOpzionali.equals(other.gruppiOpzionali))
      return false;
    if (idCorsoDiLaurea != other.idCorsoDiLaurea)
      return false;
    if (idCurriculum != other.idCurriculum)
      return false;
    if (nomeCurriculum == null) {
      if (other.nomeCurriculum != null)
        return false;
    } else if (!nomeCurriculum.equals(other.nomeCurriculum))
      return false;
    return true;
  }

  // VARIABILI DI ISTANZA
  private String nomeCurriculum;
  private int idCurriculum;
  private int idCorsoDiLaurea;
  private ArrayList<GruppoEsamiObbligatoriBean> gruppiObbligatori;
  private ArrayList<GruppoEsamiOpzionaliBean> gruppiOpzionali;

  // COSTRUTTORI
  public CurriculumBean() {
  }

  /**
   * Metodo costruttore con parametri.
   * @param nomeCurriculum nome del curriculum
   * @param idCurriculum id del curriculum
   * @param idCorsoDiLaurea id del corso di laurea
   * @param gruppiObbligatori lista di gruppi obbligatori 
   * @param gruppiOpzionali lista di gruppi opzionali 
   */
  public CurriculumBean(String nomeCurriculum, int idCurriculum, int idCorsoDiLaurea,
      ArrayList<GruppoEsamiObbligatoriBean> gruppiObbligatori, 
      ArrayList<GruppoEsamiOpzionaliBean> gruppiOpzionali) {
    this.nomeCurriculum = nomeCurriculum;
    this.idCurriculum = idCurriculum;
    this.idCorsoDiLaurea = idCorsoDiLaurea;
    this.gruppiObbligatori = gruppiObbligatori;
    this.gruppiOpzionali = gruppiOpzionali;
  }

  // GETTER E SETTER
  public String getNomeCurriculum() {
    return nomeCurriculum;
  }

  public void setNomeCurriculum(String nomeCurriculum) {
    this.nomeCurriculum = nomeCurriculum;
  }

  public int getIdCurriculum() {
    return idCurriculum;
  }

  public void setIdCurriculum(int idCurriculum) {
    this.idCurriculum = idCurriculum;
  }

  public int getIdCorsoDiLaurea() {
    return idCorsoDiLaurea;
  }

  public void setIdCorsoDiLaurea(int idCorsoDiLaurea) {
    this.idCorsoDiLaurea = idCorsoDiLaurea;
  }

  public ArrayList<GruppoEsamiObbligatoriBean> getGruppi_obbligatori() {
    return gruppiObbligatori;
  }

  public void setGruppi_obbligatori(ArrayList<GruppoEsamiObbligatoriBean> gruppiObbligatori) {
    this.gruppiObbligatori = gruppiObbligatori;
  }

  public ArrayList<GruppoEsamiOpzionaliBean> getGruppi_opzionali() {
    return gruppiOpzionali;
  }

  public void setGruppi_opzionali(ArrayList<GruppoEsamiOpzionaliBean> gruppiOpzionali) {
    this.gruppiOpzionali = gruppiOpzionali;
  }

  // METODI OBJECT
  @Override
  public String toString() {
    return "Curriculum [nomeCurriculum=" + nomeCurriculum + ", idCurriculum=" 
        + idCurriculum + ", idCorsoDiLaurea=" + idCorsoDiLaurea + "]";
  }
}
