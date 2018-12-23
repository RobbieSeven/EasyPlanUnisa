package model;

import java.util.ArrayList;

public class GruppoEsamiObbligatoriBean {

	//VARIABILI D'ISTANZA
	private int codiceGEOb;
	private int anno;
	private int idCurriculum;
	private ArrayList <EsameBean> esami;
	
	//COSTRUTTORI
	public GruppoEsamiObbligatoriBean() {};
	
	public GruppoEsamiObbligatoriBean(int codiceGEOb, int anno, int idCurriculum, ArrayList<EsameBean> esami) {
		this.codiceGEOb = codiceGEOb;
		this.anno = anno;
		this.idCurriculum = idCurriculum;
		this.esami = esami;
	}

	//GETTER E SETTER
	public int getCodiceGEOb() {
		return codiceGEOb;
	}

	public void setCodiceGEOb(int codiceGEOb) {
		this.codiceGEOb = codiceGEOb;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
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

	//METODI OBJECT
	@Override
	public String toString() {
		return "GruppoEsamiObbligatoriBean [codiceGEOb=" + codiceGEOb + ", anno=" + anno + ", idCurriculum="
				+ idCurriculum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + codiceGEOb;
		result = prime * result + idCurriculum;
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
		GruppoEsamiObbligatoriBean other = (GruppoEsamiObbligatoriBean) obj;
		if (anno != other.anno)
			return false;
		if (codiceGEOb != other.codiceGEOb)
			return false;
		if (idCurriculum != other.idCurriculum)
			return false;
		return true;
	}
	
}

