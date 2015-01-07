import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Interface {
Panneau panneau;
Fenetre fenetre;



JLabel resultat=new JLabel("La convergence est obtenue en : ");

public Interface(int facteurGrossissement) throws InterruptedException{
	Plateau plateau=new Plateau();
	
	this.panneau=new Panneau(plateau,facteurGrossissement);
	this.fenetre=new Fenetre(this.panneau);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
}
