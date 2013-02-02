package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.Controller;
import Model.Participant;

public class BirouWindow extends JFrame implements Observer {
	private Controller contr;
	private JList birou_list;
	private JTextField min_text;
	private JTextField max_text;
	private JButton cauta_button;
	private JList participanti_list;
	private JTextField nume_text;
	private JTextField varsta_text;
	private JButton adauga_button;
	private int id;
	
	public BirouWindow(String titlu,int id,Controller contr) {
		super(titlu);
		this.contr = contr;
		this.id = id;
		
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(4,1));
		
		birou_list = new JList(contr.getBirouri().toArray()); 
		main.add(new JScrollPane(birou_list));
		
		JPanel secondary = new JPanel();
		secondary.setLayout(new GridLayout(1,5));
		
		secondary.add(new JLabel("Varsta minima:"));
		min_text = new JTextField(10);
		secondary.add(min_text);
		secondary.add(new JLabel("Varsta maxima:"));
		max_text = new JTextField(10);
		secondary.add(max_text);
		
		cauta_button = new JButton("Cauta");
		secondary.add(cauta_button);
		cauta_button.addActionListener(new ButtonHandler());
		main.add(secondary);
		
		participanti_list = new JList();
		main.add(participanti_list);
		
		secondary = new JPanel();
		secondary.add(new JLabel("Nume:"));
		nume_text = new JTextField(10);
		secondary.add(nume_text);
		secondary.add(new JLabel("Varsta:"));
		varsta_text = new JTextField(10);
		secondary.add(varsta_text);
		
		adauga_button = new JButton("Adauga");
		secondary.add(adauga_button);
		adauga_button.addActionListener(new ButtonHandler());
		main.add(secondary);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				BirouWindow.this.contr.close();
			}
		});
		this.add(main);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		birou_list.setListData(contr.getBirouri().toArray());
		
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			if (ev.getSource() == adauga_button) {
				contr.adaugaParticipant(id, nume_text.getText(), Integer.parseInt(varsta_text.getText()));
			}
			if (ev.getSource() == cauta_button) {
				List<Participant> l = contr.cautaDupaVarsta(Integer.parseInt(min_text.getText()), 
							Integer.parseInt(max_text.getText()));
				participanti_list.setListData(l.toArray());
			}
		}
		
	}
}
