package model;

public class Curriculum {

	//VARIABILI DI ISTANZA
	private String nomeCurriculum;
	private int idCurriculum;
	private int idCorsoDiLaurea;
	
	//COSTRUTTORI
	public Curriculum() {
		
	}
	
	public Curriculum(String nomeCurriculum, int idCurriculum, int idCorsoDiLaurea) {
		super();
		this.nomeCurriculum = nomeCurriculum;
		this.idCurriculum = idCurriculum;
		this.idCorsoDiLaurea = idCorsoDiLaurea;
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
		Curriculum other = (Curriculum) obj;
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
