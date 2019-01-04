package model;

import java.util.ArrayList;

public class EsameBean {

	// VARIABILI D'ISTANZA
	private int codiceEsame;
	private String nome;
	private int CFU;
	private String descrizione;
	private int oreLezione;
	private String semestre;
	private ArrayList<DocenteBean> docenti = new ArrayList<DocenteBean>();
	private boolean check = false;

	// COSTRUTTORI
	public EsameBean() {
	};

	public EsameBean(int codiceEsame, String nome, int CFU, String descrizione, int oreLezione, String semestre) {
		this.codiceEsame = codiceEsame;
		this.nome = nome;
		this.CFU = CFU;
		this.descrizione = descrizione;
		this.oreLezione = oreLezione;
		this.semestre = semestre;
	}

	// GETTER E SETTER
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

	public int getOreLezione() {
		return oreLezione;
	}

	public void setOreLezione(int oreLezione) {
		this.oreLezione = oreLezione;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public ArrayList<DocenteBean> getDocenti() {
		return docenti;
	}

	public void setDocenti(ArrayList<DocenteBean> docenti) {
		this.docenti = docenti;
	}
	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	// METODI OBJECT
	@Override
	public String toString() {
		return "EsameBean [codiceEsame=" + codiceEsame + ", nome=" + nome + ", CFU=" + CFU + ", descrizione="
				+ descrizione + ", ore_lezione=" + oreLezione + ", semestre=" + semestre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CFU;
		result = prime * result + codiceEsame;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + oreLezione;
		result = prime * result + ((semestre == null) ? 0 : semestre.hashCode());
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
		if (oreLezione != other.oreLezione)
			return false;
		if (semestre == null) {
			if (other.semestre != null)
				return false;
		} else if (!semestre.equals(other.semestre))
			return false;
		return true;
	}

}
