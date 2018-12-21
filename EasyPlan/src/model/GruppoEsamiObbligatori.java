package model;

public class GruppoEsamiObbligatori {

	//VARIABILI D'ISTANZA
	private int codiceGEOb;
	private String anno;
	private int idCurriculum;
	
	//COSTRUTTORI
	public GruppoEsamiObbligatori() {};

	public GruppoEsamiObbligatori(int codiceGEOb, String anno, int idCurriculum) {
		this.codiceGEOb = codiceGEOb;
		this.anno = anno;
		this.idCurriculum = idCurriculum;
	}

	//GETTER E SETTER
	public int getCodiceGEOb() {
		return codiceGEOb;
	}

	public void setCodiceGEOb(int codiceGEOb) {
		this.codiceGEOb = codiceGEOb;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
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
		return "GruppoEsamiObbligatori [codiceGEOb=" + codiceGEOb + ", anno=" + anno + ", idCurriculum=" + idCurriculum
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
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
		GruppoEsamiObbligatori other = (GruppoEsamiObbligatori) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (codiceGEOb != other.codiceGEOb)
			return false;
		if (idCurriculum != other.idCurriculum)
			return false;
		return true;
	}
	
}

