//Copyright © 2015 Oisin Smith All Rights Reserved
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Level6 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	int schritte = 0;
    do{
    	setzteKorn(schritte % 2);
    	vor();
    	schritte++;
    }while(vornFrei());
}


void setzteKorn(int anzahl){
	int i = 0;
	while(kornDa()){
		nimm();
	}
	while(anzahl > i){
		gib();
		i++;
	}
}
}