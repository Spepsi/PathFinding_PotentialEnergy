
public class Case {
boolean  estLibre;
double champs;
double champsProduit;

public Case(){
	this.estLibre=(Math.random()<0.75);
	if(this.estLibre){
		this.champsProduit=0;
	}
	else this.champsProduit=10000;
}

}
