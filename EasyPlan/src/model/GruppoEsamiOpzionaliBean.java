package model;

public class GruppoEsamiOpzionaliBean {

	//VARIABILI D'ISTANZA
	private int codiceGEOp;
	private int anno;
	private int totCFU;
	private int idCurriculum;
	
	//COSTRUTTORI
	public GruppoEsamiOpzionaliBean() {};

	public GruppoEsamiOpzionaliBean(int codiceGEOp, int anno, int totCFU, int idCurriculum) {
		this.codiceGEOp = codiceGEOp;
		this.anno = anno;
		this.totCFU = totCFU;
		this.idCurriculum = idCurriculum;
	}

	//GETTER E SETTER
	public int getCodiceGEOp() {
		return codiceGEOp;
	}

	public void setCodiceGEOp(int codiceGEOp) {
		this.codiceGEOp = codiceGEOp;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getTotCFU() {
		return totCFU;
	}

	public void setTotCFU(int totCFU) {
		this.totCFU = totCFU;
	}

	public int getIdCurriculum() {
		return idCurriculum;
	}

	public void setIdCurriculum(int idCurriculum) {
		this.idCurriculum = idCurriculum;
	}

	//METODI OBJECT
	@Override
	public String toString() {
		return "GruppoEsamiOpzionali [codiceGEOp=" + codiceGEOp + ", anno=" + anno + ", totCFU=" + totCFU
				+ ", idCurriculum=" + idCurriculum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + codiceGEOp;
		result = prime * result + idCurriculum;
		result = prime * result + totCFU;
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
		if (codiceGEOp != other.codiceGEOp)
			return false;
		if (idCurriculum != other.idCurriculum)
			return false;
		if (totCFU != other.totCFU)
			return false;
		return true;
	}
	
}
