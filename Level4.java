import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Level4 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	int breite = 0;
	while(!kornDa()){
		linksUm();
		breite = bisZurWand();
		nimm();
		kehr();
		bisZurWand();
		nimm();
		kehr();
		schritte(breite);
		drehe(3);
		schritte(2);
	}	    
	while(kornDa()){
		nimm();
	}
}

int bisZurWand(){
	int schritte = 0;
	while(vornFrei()){
		vor();
		schritte++;
	}
	return schritte;
}

void kehr(){
	linksUm();
	linksUm();
}

void schritte(int schritte){
	int i = 0;
	while(i < schritte){
		if(vornFrei()){
			vor();
		}
		i++;
	}
}

void drehe(int drehungen){
	int i = 0;
	while(i < drehungen){
		linksUm();
		i++;
	}
}}