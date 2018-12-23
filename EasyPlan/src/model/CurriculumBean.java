package model;

import java.util.ArrayList;

public class CurriculumBean {

	//VARIABILI DI ISTANZA
	private String nomeCurriculum;
	private int idCurriculum;
	private int idCorsoDiLaurea;
	private ArrayList <GruppoEsamiObbligatoriBean> gruppi_obbligatori;
	private ArrayList <GruppoEsamiOpzionaliBean> gruppi_opzionali;
	
	//COSTRUTTORI
	public CurriculumBean() {}
	
	public CurriculumBean(String nomeCurriculum, int idCurriculum, int idCorsoDiLaurea,
			ArrayList<GruppoEsamiObbligatoriBean> gruppi_obbligatori,
			ArrayList<GruppoEsamiOpzionaliBean> gruppi_opzionali) {
		this.nomeCurriculum = nomeCurriculum;
		this.idCurriculum = idCurriculum;
		this.idCorsoDiLaurea = idCorsoDiLaurea;
		this.gruppi_obbligatori = gruppi_obbligatori;
		this.gruppi_opzionali = gruppi_opzionali;
	}

	//GETTER E SETTER
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
		return gruppi_obbligatori;
	}

	public void setGruppi_obbligatori(ArrayList<GruppoEsamiObbligatoriBean> gruppi_obbligatori) {
		this.gruppi_obbligatori = gruppi_obbligatori;
	}

	public ArrayList<GruppoEsamiOpzionaliBean> getGruppi_opzionali() {
		return gruppi_opzionali;
	}

	public void setGruppi_opzionali(ArrayList<GruppoEsamiOpzionaliBean> gruppi_opzionali) {
		this.gruppi_opzionali = gruppi_opzionali;
	}

	//METODI OBJECT
	@Override
	public String toString() {
		return "Curriculum [nomeCurriculum=" + nomeCurriculum + ", idCurriculum=" + idCurriculum + ", idCorsoDiLaurea="
				+ idCorsoDiLaurea + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
	
}
