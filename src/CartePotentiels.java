import javax.swing.JFrame;
import javax.swing.JPanel;


public class CartePotentiels extends JFrame {
	
	JPanel panneau;
	
	public CartePotentiels(){
		
		this.panneau=new JPanel();
		
		
		this.setTitle("Test intelligence artificielle");
		this.setBounds(0,0, panneau.getWidth()+750, panneau.getHeight()+150);
		this.add(panneau);
		//this.add(new JButton("Start"),BorderLayout.EAST);
		this.setVisible(true);
		this.setResizable(true);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

}
