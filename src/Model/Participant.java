package Model;

public class Participant {
	private String nume;
	private int varsta;
	private int birou_id;
	
	public Participant(String nume, int varsta, int birou) {
		this.nume = nume;
		this.varsta = varsta;
		this.setBirou_id(birou);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birou_id;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + varsta;
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
		Participant other = (Participant) obj;
		if (birou_id != other.birou_id)
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (varsta != other.varsta)
			return false;
		return true;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public int getBirou_id() {
		return birou_id;
	}

	public void setBirou_id(int birou_id) {
		this.birou_id = birou_id;
	}

	@Override
	public String toString() {
		return nume + ";" + varsta + ";" + getBirou_id() + "\n";
	}
	
	
	
}
