import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Controller.Controller;
import Repository.BirouRepository;
import Repository.ParticipantRepository;
import UI.BirouWindow;


public class Main {

	public static String[] ARGS;
	private ParticipantRepository prep;
	private BirouRepository brep;
	public void setPrep(ParticipantRepository prep) {
		this.prep = prep;
	}
	public void setBrep(BirouRepository brep) {
		this.brep = brep;
	}
	public void setContr(Controller contr) {
		this.contr = contr;
	}
	private Controller contr;
	
	public void start() {
		for (String string : ARGS) {
			int id = brep.addBirou(string);
			BirouWindow bw = new BirouWindow(string,id,contr);
			bw.setSize(400, 500);
			bw.setVisible(true);
			brep.addObserver(bw);
		}
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ARGS = args;
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
		Main application = (Main) factory.getBean("main");
		application.start();	

	}

}
