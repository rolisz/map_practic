package Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import Model.Birou;

public class BirouRepository extends Observable {
	private List<Birou> birouri;
	private String fisier = "birouri.txt";
	private int maxId = 0;
	
	public BirouRepository() {
		birouri = new ArrayList<Birou>();
		readFromFile();
	}

	private void readFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fisier));
			String input;
			while ((input = br.readLine()) != null) {
				String[] campuri = input.split(";");
				birouri.add(new Birou(Integer.parseInt(campuri[0]),campuri[1],Integer.parseInt(campuri[2])));
				maxId++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fisier));
			Iterator<Birou> it = birouri.iterator();
			while (it.hasNext()) {
				bw.write(it.next().toString());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Birou> getBirouri() {
		return this.birouri;
	}

	public void incParticipant(int birou) {
		for (Birou bir : birouri) {
			if (bir.getId() == birou) {
				bir.incrementParticipanti();
				break;
			}
		}
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}

	public int addBirou(String nume) {
		boolean found = false;
		for (Birou bir : birouri) {
			if (bir.getNume().equals(nume)) {
				found = true;
				return bir.getId();
			}
		}
		if (!found) {
			birouri.add(new Birou(maxId,nume,0));
			maxId++;
			return maxId-1;
		}
		return -1;
	}
	
	
}
