import java.util.LinkedList;


public class Personnage {
	Case voisinNord;
	Case voisinEst;
	Case voisinSud;
	Case voisinOuest;
	
	int curseurPrecedent;
	int curseurPrecedentPrecedent;
	
	boolean succes=false;
	
	LinkedList<Couple> listeDeplacements=new LinkedList<Couple>();

	int X;
	int Y;

	int nombrePas;


	public Personnage(){
		this.X=2;
		this.Y=2;
		this.nombrePas=0;

	}
	public void deplacement(){
		this.listeDeplacements.add(new Couple(this.X,this.Y));
		int curseur=-1;
		double champsMin=500000000;
		if(voisinNord.champs<=champsMin && this.voisinNord.estLibre){
			champsMin=voisinNord.champs;
			curseur=0;
		}
		if(voisinEst.champs<=champsMin && this.voisinEst.estLibre){
			champsMin=voisinEst.champs;
			curseur=1;
		}
		if(voisinSud.champs<=champsMin && this.voisinSud.estLibre){
			champsMin=voisinSud.champs;
			curseur=2;
		}
		if(voisinOuest.champs<=champsMin && this.voisinOuest.estLibre){
			champsMin=voisinOuest.champs;
			curseur=3;
		}
		//System.out.println(curseur);
		switch(curseur){
		case 0 :
			this.Y--;
			break;
		case 1 :
			this.X++;
			break;
		case 2 :
			this.Y++;
			break;
		case 3 :
			this.X--;
			break;
			
		}
		nombrePas++;
	}


}
