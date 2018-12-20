package Model;

public class EsameBean {
	
	//VARIABILI D'ISTANZA
	private int codiceEsame;
	private String nome;
	private int CFU;
	private String descrizione;
	private int ore_lezione;
	private boolean semestre;
	
	//COSTRUTTORI
	public EsameBean() {};
	
	public EsameBean(int codiceEsame, String nome, int cFU, String descrizione, int ore_lezione, boolean semestre) {
		this.codiceEsame = codiceEsame;
		this.nome = nome;
		CFU = cFU;
		this.descrizione = descrizione;
		this.ore_lezione = ore_lezione;
		this.semestre = semestre;
	}
	
	//GETTER E SETTER
	public int getCodiceEsame() {
		return codiceEsame;
	}
	
	public void setCodiceEsame(int codiceEsame) {
		this.codiceEsame = codiceEsame;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCFU() {
		return CFU;
	}
	
	public void setCFU(int cFU) {
		CFU = cFU;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getOre_lezione() {
		return ore_lezione;
	}
	
	public void setOre_lezione(int ore_lezione) {
		this.ore_lezione = ore_lezione;
	}
	
	public boolean isSemestre() {
		return semestre;
	}
	
	public void setSemestre(boolean semestre) {
		this.semestre = semestre;
	}

	//METODI OBJECT
	@Override
	public String toString() {
		return "EsameBean [codiceEsame=" + codiceEsame + ", nome=" + nome + ", CFU=" + CFU + ", descrizione="
				+ descrizione + ", ore_lezione=" + ore_lezione + ", semestre=" + semestre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CFU;
		result = prime * result + codiceEsame;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ore_lezione;
		result = prime * result + (semestre ? 1231 : 1237);
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
		EsameBean other = (EsameBean) obj;
		if (CFU != other.CFU)
			return false;
		if (codiceEsame != other.codiceEsame)
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ore_lezione != other.ore_lezione)
			return false;
		if (semestre != other.semestre)
			return false;
		return true;
	}
}
