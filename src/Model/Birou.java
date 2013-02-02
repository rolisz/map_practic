package Model;

public class Birou {
	private String nume;
	private int nr_participanti;
	private int id;
	
	public Birou(int id,String nume, int nr_participanti) {
		this.id = id;
		this.nume = nume;
		this.nr_participanti = nr_participanti;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getNr_participanti() {
		return nr_participanti;
	}

	public void setNr_participanti(int nr_participanti) {
		this.nr_participanti = nr_participanti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nr_participanti;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		return result;
	}

	public void incrementParticipanti() {
		this.nr_participanti++;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Birou other = (Birou) obj;
		if (nr_participanti != other.nr_participanti)
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + ";" + nume + ";" + nr_participanti+"\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
