import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau extends JPanel implements ActionListener{
	JLabel moyenne=new JLabel("");
	Plateau plateau;
	Panneau panneau;
	int facteurGrossissement;
	double moyenneEssais=0;
	boolean afficherCarte=false;
	JButton boutonAfficherPotentiels=new JButton("Afficher Carte Potentiels");

	JButton boutonRecommencer=new JButton("Recommencer");

	boolean recommencer=true;
	int nombreEssai=0;

	public Panneau(Plateau plateau,int grossissement){
		this.plateau=plateau;
		this.facteurGrossissement=grossissement;
		this.setBounds(0,0,this.plateau.largeur*this.facteurGrossissement,this.plateau.longueur*this.facteurGrossissement);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		//this.setVisible(true);
		this.repaint();
		this.boutonRecommencer.setBounds(700, 50, 150,25);
		this.boutonRecommencer.addActionListener(this);
		this.boutonAfficherPotentiels.setBounds(700, 100, 200, 25);
		this.boutonAfficherPotentiels.addActionListener(this);
		this.add(boutonRecommencer);
		this.add(boutonAfficherPotentiels);
		this.add(this.moyenne);
		//this.setForeground(Color.WHITE);
	}



	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		if(!this.afficherCarte){
			for(int i=0;i<plateau.largeur;i++){
				for(int j=0;j<plateau.longueur;j++){
					if(plateau.tableau[i][j].estLibre){
						g.setColor(Color.WHITE);
						g.fillRect(i*this.facteurGrossissement, j*this.facteurGrossissement, this.facteurGrossissement, this.facteurGrossissement);
					}
					else{
						g.setColor(Color.BLACK);
						g.fillRect(i*this.facteurGrossissement, j*this.facteurGrossissement, this.facteurGrossissement, this.facteurGrossissement);
					}
				}


				g.setColor(Color.GREEN);
				for( Couple couple : this.plateau.perso.listeDeplacements ){
					g.fillRect(couple.X*this.facteurGrossissement, couple.Y*this.facteurGrossissement, 
							this.facteurGrossissement, this.facteurGrossissement);
				}
				g.setColor(Color.RED);
				g.fillRect(this.plateau.objectif.X*this.facteurGrossissement, this.plateau.objectif.Y*this.facteurGrossissement, 
						this.facteurGrossissement, this.facteurGrossissement);
				g.setColor(Color.BLUE);
				g.fillRect(this.plateau.perso.X*this.facteurGrossissement, this.plateau.perso.Y*this.facteurGrossissement, 
						this.facteurGrossissement, this.facteurGrossissement);
			}
		}
			else {
				for(int i=0;i<plateau.largeur;i++){
					for(int j=0;j<plateau.longueur;j++){
						if(plateau.tableau[i][j].estLibre){
							float pot = (float)Math.abs((plateau.tableau[i][j].champs)/2000000000+1);
							pot = ((float)100000.0)*Math.abs(pot-1);
							//g.setColor(Color.getHSBColor(pot,pot,pot));
							g.setColor(Color.getHSBColor(100,100,100*pot));
							System.out.println(pot);
						}
						else{
							g.setColor(Color.RED);
						}
						g.fillRect(i*this.facteurGrossissement, j*this.facteurGrossissement, this.facteurGrossissement, this.facteurGrossissement);

					}
				}
			}




		}

		public void go() throws InterruptedException{
			this.recommencer=true;
			this.plateau.calculChamps();
			while(!this.plateau.perso.succes){
				Thread.sleep(10);
				this.plateau.EtatSuivant();
				this.repaint();
				if(this.plateau.perso.succes){
					this.nombreEssai++;
					this.moyenneEssais=((this.nombreEssai-1)*this.moyenneEssais+this.plateau.perso.nombrePas)/((double) this.nombreEssai);
					this.moyenne.setText("Moyenne : "+this.moyenneEssais+" pas");
					this.moyenne.setBounds(700, 100, 500, 25);
					JLabel resultat=new JLabel("Succès de l'algorithme en "+this.plateau.perso.nombrePas+" pas.");
					resultat.setBounds(700, 150+this.nombreEssai*30, 500, 25);
					this.add(resultat);
				}
			}
		}



		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==this.boutonRecommencer){
				this.recommencer=true;
				plateau.reinitialiser();


			}
			if(arg0.getSource()==this.boutonAfficherPotentiels){
				this.afficherCarte=!this.afficherCarte;

				repaint();

			}
			


		}

	}


