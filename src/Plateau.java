
public class Plateau {
	int largeur=50;
	int longueur=50;
	Personnage perso;
	Objectif objectif;

	Case[][] tableau=new Case[this.largeur][this.longueur];

	public Plateau(){
		this.perso=new Personnage();
		this.objectif=new Objectif();
		for(int i=0; i<largeur;i++){
			for(int j=0;j<longueur;j++){
				this.tableau[i][j]=new Case();
			}
		}
		for(int j=0;j<largeur;j++){
			this.tableau[j][longueur-1].estLibre=false;
		}
		for(int j=0;j<largeur;j++){
			this.tableau[j][0].estLibre=false;
		}
		for(int j=0;j<longueur;j++){
			this.tableau[0][j].estLibre=false;
		}
		for(int j=0;j<longueur;j++){
			this.tableau[largeur-1][j].estLibre=false;
		}
		this.tableau[2][2].estLibre=false;
		this.tableau[40][40].estLibre=true;
	}
	public void assignerVoisins(){
		this.perso.voisinEst=this.tableau[this.perso.X+1][this.perso.Y];
		this.perso.voisinOuest=this.tableau[this.perso.X-1][this.perso.Y];
		this.perso.voisinSud=this.tableau[this.perso.X][this.perso.Y+1];
		this.perso.voisinNord=this.tableau[this.perso.X][this.perso.Y-1];
	}

	public void calculChamps(){
		for(int i=0;i<largeur;i++){
			for(int j=0;j<longueur;j++){
				if(!this.tableau[i][j].estLibre){
					for(int k=0;k<largeur;k++){
						for(int l=0;l<longueur;l++){
							if(j!=l && i!=k && this.tableau[k][l].estLibre){
								this.tableau[k][l].champs+=this.tableau[i][j].champsProduit/
										(Math.pow((Math.abs(i-k)+Math.abs(j-l)+1), 2));
							}
						}
					}
				}
			}
		}
		for(int i=0;i<largeur;i++){
			for(int j=0;j<longueur;j++){
				this.tableau[i][j].champs+=(this.objectif.champs)/(Math.pow((Math.abs(i-this.objectif.X)+Math.abs(j-this.objectif.Y)+1), 3));
			}
		}
	}

	public void calculChampsDeplacement(){
		for(int i=0;i<largeur;i++){
			for(int j=0;j<longueur;j++){
				this.tableau[i][j].champs+=(800000)/(Math.pow((Math.abs(i-this.perso.X)+Math.abs(j-this.perso.Y)+1),3));
			}
		}
	}

	public void EtatSuivant(){
		this.assignerVoisins();
		this.calculChampsDeplacement();
		//this.tableau[this.perso.X][this.perso.Y].estLibre=false;
		this.perso.deplacement();
		if(this.perso.X==this.objectif.X && this.perso.Y==this.objectif.Y){
			this.perso.succes=true;
			System.out.println("objectif atteint en "+this.perso.nombrePas+ " pas");
		}
	}
	public void reinitialiser() {
		this.perso.X=2;
		this.perso.Y=2;
		this.perso.listeDeplacements.clear();
		this.perso.nombrePas=0;
		
		this.perso.succes=false;
		
		for(int i=0; i<largeur;i++){
			for(int j=0;j<longueur;j++){
				this.tableau[i][j]=new Case();
			}
		}
		for(int j=0;j<largeur;j++){
			this.tableau[j][longueur-1].estLibre=false;
		}
		for(int j=0;j<largeur;j++){
			this.tableau[j][0].estLibre=false;
		}
		for(int j=0;j<longueur;j++){
			this.tableau[0][j].estLibre=false;
		}
		for(int j=0;j<longueur;j++){
			this.tableau[largeur-1][j].estLibre=false;
		}
		//this.tableau[1][1].estLibre=false;
		this.tableau[40][40].estLibre=true;
		
		this.calculChamps();
		
	}
}

