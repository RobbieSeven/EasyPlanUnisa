package model.curriculum;

import java.util.ArrayList;

import model.gruppo.esami.obbligatori.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.opzionali.GruppoEsamiOpzionaliBean;

public class CurriculumBean {

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
