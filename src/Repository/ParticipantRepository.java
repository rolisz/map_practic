package Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Participant;

public class ParticipantRepository {
	private List<Participant> participanti;
	private String fisier = "participanti.txt";
	
	public ParticipantRepository() {
		participanti = new ArrayList<Participant>();
		readFromFile();
	}

	private void readFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fisier ));
			String input;
			while ((input = br.readLine()) != null) {
				String[] campuri = input.split(";");
				participanti.add(new Participant(campuri[0], Integer.parseInt(campuri[1]), Integer.parseInt(campuri[2])));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fisier));
			for (Participant part : participanti) {
				bw.write(part.toString());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adaugaParticipant(Participant participant) {
		this.participanti.add(participant);
	}

	public List<Participant> cautaDupaVarsta(int min, int max) {
		List<Participant> temp = new ArrayList<Participant>();
		for (Participant part : participanti) {
			if (part.getVarsta() >= min && part.getVarsta() <= max) {
				temp.add(part);
			}
		}
		return temp;
	}
	
}
