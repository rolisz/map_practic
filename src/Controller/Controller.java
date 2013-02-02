package Controller;

import java.util.List;

import Model.Birou;
import Model.Participant;
import Repository.BirouRepository;
import Repository.ParticipantRepository;

public class Controller {
	private BirouRepository birouRep;
	private ParticipantRepository partRep;
	
	public Controller(BirouRepository birouRep, ParticipantRepository partRep) {
		this.birouRep = birouRep;
		this.partRep = partRep;
	}
	
	public List<Birou> getBirouri() {
		return birouRep.getBirouri();
	}
	 public List<Participant> cautaDupaVarsta(int min,int max) {
		return partRep.cautaDupaVarsta(min,max);		 
	 }
	 
	 public void adaugaParticipant(int birou,String nume, int varsta) {
		 partRep.adaugaParticipant(new Participant(nume,varsta,birou));
		 birouRep.incParticipant(birou);
	 }

	public void close() {
		birouRep.writeToFile();
		partRep.writeToFile();
		
	}
}
