//Copyright © 2015 Oisin Smith Some Rights Reserved
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Level5 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void zugKI(){
	int feld1 = pruefeKorn(1); // Diese Variablen enthalten wer in welchem feld ist.
	int feld2 = pruefeKorn(2); // Siehe unter für welche Var welchem Feld entspricht.
	int feld3 = pruefeKorn(3);
	int feld4 = pruefeKorn(4);
	int feld5 = pruefeKorn(5);
	int feld6 = pruefeKorn(6);
	int feld7 = pruefeKorn(7);
	int feld8 = pruefeKorn(8);
	int feld9 = pruefeKorn(9);
	/*
  	7|8|9
  	4|5|6
  	1|2|3
	*/
	
	
	
	
	
	
	
	
	setzteKornKI(1); //Am ende eures Codes muss hier ein wert landen!
}




/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
ALLES CODED UNTER DIESEM STRICH DARF NICHT VERÄNDET WERDEN! Ihr dürft es aber lesen :)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
public void main(){
	boolean intro = false; // Hier das Intro an/aus stellen
	boolean enableKI = false;
	if(intro){intro();}
	nimmAnzahl(20);
   	int spieler =  1;
   	schreib("Spieler 1 beginnt!");
   	int gewonnen = 0;
   	while(gewonnen == 0){	
   		if(spieler == 1){
   			machZug(spieler);
   			spieler = 2;
   		}else{
   			if(enableKI){
   				zugKI();
   			}else{
   				machZug(spieler);
   			}
   			spieler = 1;
   		}
   		gewonnen = gewonnen();
   	}
   	if(gewonnen != 3){
   		schreib("Herzlich glückwunsch Spieler " + gewonnen + ". Du hast gewonnen!");
   	}else{
   		schreib("Unentschieden!");
   	}	
   	schreib("Nicht vergessen das Board zu resetten und danke fürs Spielen!");
	
}

int gewonnen(){
	/*
	Win Möglichkeiten:
	7-8-9 4-5-6 1-2-3
	1-4-7 2-5-8 3-6-9
	1-5-9 3-5-7
	*/
	int feld1 = pruefeKorn(1);
	int feld2 = pruefeKorn(2);
	int feld3 = pruefeKorn(3);
	int feld4 = pruefeKorn(4);
	int feld5 = pruefeKorn(5);
	int feld6 = pruefeKorn(6);
	int feld7 = pruefeKorn(7);
	int feld8 = pruefeKorn(8);
	int feld9 = pruefeKorn(9);
	
	if((feld1 == 1 && feld2 == 1 && feld3 == 1) ||
	(feld4 == 1 && feld5 == 1 && feld6 == 1)||
	(feld7 == 1 && feld8 == 1 && feld9 == 1)||
	(feld1 == 1 && feld4 == 1 && feld7 == 1)||
	(feld2 == 1 && feld5 == 1 && feld8 == 1)||
	(feld3 == 1 && feld6 == 1 && feld9 == 1)||
	(feld3 == 1 && feld5 == 1 && feld7 == 1)||
	(feld1 == 1 && feld5 == 1 && feld8 == 1)){
		return 1;
	}else if((feld1 == 2 && feld2 == 2 && feld3 == 2) ||
	(feld4 == 2 && feld5 == 2 && feld6 == 2)||
	(feld7 == 2 && feld8 == 2 && feld9 == 2)||
	(feld1 == 2 && feld4 == 2 && feld7 == 2)||
	(feld2 == 2 && feld5 == 2 && feld8 == 2)||
	(feld3 == 2 && feld6 == 2 && feld9 == 2)||
	(feld3 == 2 && feld5 == 2 && feld7 == 2)||
	(feld1 == 2 && feld5 == 2 && feld8 == 2)){
		return 2;
	}else if(feld1 != 0 && feld2 != 0 && feld3 != 0 && feld4 != 0 && feld5 != 0 && feld6 != 0 && feld7 != 0 && feld8 != 0 && feld9 != 0){
		return 3;
	}else{
		return 0;
	}
	
}

void intro(){
	schreib("Willkommen bei Tic-Tac-To von Oisin");
	schreib("Dieses Spiel ist für 2 Personen gedacht");
	schreib("Das Feld sieht so aus:\n7|8|9\n4|5|6\n1|2|3");
	schreib("Jeder macht abwechseld sein Zug, indem er eine Zahl von 1-9 eingibt");
	schreib("Viel Spaß");	
}
/*
    1 2 3 X
  3 7|8|9
  2 4|5|6
  1 1|2|3
  Y
*/
int pruefeKorn(int zug){
	int y = 1;
	int x = 1;
	if(zug == 3 || zug == 6 || zug == 9){ // 3, 6, 9
		x = 3;
	}else if(zug == 2 || zug == 5 || zug == 8){ // 2, 5, 8
		x = 2;
	}		
	if(zug >= 7){
		y = 3;	
	}else if(zug >= 4){
		y = 2;
	}
	vorUm(2 * y - 1);
	dreheUm(3);
	vorUm(2 * x - 2);
	int anzahl = anzahlKoerner();
	dreheUm(2);
	vorUm(2 * x - 2);
	dreheUm(1);
	vorUm(2 * y - 1);
	dreheUm(2);
	return anzahl;
}

int anzahlKoerner(){
	int i = 0;
	int k = 0;
	while(kornDa()){
		nimm();
		i++;
	}
	while(k < i){
		gib();
		k++;
	}
	return i;
}

void machZug(int spieler){
	int zug = fragZug(spieler);
	if(pruefeKorn(zug) == 0){
		int y = 1;
		int x = 1;
		if(zug == 3 || zug == 6 || zug == 9){ // 3, 6, 9
			x = 3;
		}else if(zug == 2 || zug == 5 || zug == 8){ // 2, 5, 8
			x = 2;
		}		
		if(zug >= 7){
			y = 3;	
		}else if(zug >= 4){
			y = 2;
		}
		setzKorn(x, y, spieler);
	}else{
		schreib("Dieses Feld ist schon Besetzt!");
		machZug(spieler);
	}
	

}

int fragZug(int spieler){
	int zahl = liesZahl("Spieler " + spieler + ":");
	if(zahl <= 9 && zahl > 0){
		return zahl;
	}else{
		schreib("Bitte eine Zahl von 1-9 angeben!" + " (Deine Angabe: " + zahl + ")");
		fragZug(spieler);
		return 1;
	}
}

void setzteKornKI(int zug){
	int y = 1;
	int x = 1;
	if(zug == 3 || zug == 6 || zug == 9){ // 3, 6, 9
		x = 3;
	}else if(zug == 2 || zug == 5 || zug == 8){ // 2, 5, 8
		x = 2;
	}		
	if(zug >= 7){
		y = 3;	
	}else if(zug >= 4){
		y = 2;
	}
	vorUm(2 * y - 1);
	dreheUm(3);
	vorUm(2 * x - 2);
	gibKorn(2);
	dreheUm(2);
	vorUm(2 * x - 2);
	dreheUm(1);
	vorUm(2 * y - 1);
	dreheUm(2);
}

void setzKorn(int x, int y, int spieler){
	vorUm(2 * y - 1);
	dreheUm(3);
	vorUm(2 * x - 2);
	gibKorn(spieler);
	dreheUm(2);
	vorUm(2 * x - 2);
	dreheUm(1);
	vorUm(2 * y - 1);
	dreheUm(2);
}

void vorUm(int schritte){
	for(int i=0;i < schritte;i=i+1){
		vor();
	}
}
void dreheUm(int deg){
	for(int i=0;i < deg;i=i+1){
		linksUm();
	}
}

void gibKorn(int x){
	for(int i=0;i < x;i=i+1){
		gib();
	}
}

void nimmAnzahl(int anzahl){
	int i = 0;
	while(kornDa() && i < anzahl){
		nimm();
		i++;
	}
}}