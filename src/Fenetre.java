import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.MenuBar;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Fenetre extends JFrame {
	
public Fenetre(Panneau panneau) throws InterruptedException{
	
	this.setTitle("Test intelligence artificielle");
	this.setBounds(0,0, panneau.getWidth()+750, panneau.getHeight()+150);
	this.add(panneau);
	//this.add(new JButton("Start"),BorderLayout.EAST);
	this.setVisible(true);
	this.setResizable(true);
	
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	
}
