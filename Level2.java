import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Level2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    vor();
    vor();
    rechtsUm();
    vor();
    vor();
    nimm();
    kehr();
    vor();
    vor();
    vor();
    vor();
    linksUm();
    vor();
    vor();
    nimm();
    kehr();
    vor();
    vor();
    vor();
    vor();
    vor();
    vor();
    nimm();
    rechtsUm();
    vor();
    vor();
    vor();
    vor();	
    nimm();
    linksUm();
    vor();
    nimm();
}

void kehr(){
	linksUm();
	linksUm();
}
void rechtsUm(){
	kehr();
	linksUm();
}}