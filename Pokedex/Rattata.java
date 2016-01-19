//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Rattata.java
package Pokedex;

public class Rattata extends Pokemon {
	
	//Constructor
	public Rattata() {
		super( "Rattata", 5, "NORMAL" );
		addMove("Scratch", 40, 35);
		addMove("Headbutt", 70, 15);
	}
	
	//Constructor for evolutions
	public Rattata( String n, int lvl) {
		super( n, lvl, "NORMAL" );
		addMove("Scratch", 40, 35);
		addMove("Headbutt", 70, 15);
	}
	
	//Pokedex description
	public String about() {
		return "Rattata is cautious in the extreme. " +
		"Even while it is asleep, it constantly listens by moving its ears around. " +
		"It is not picky about where it lives—it will make its nest anywhere.";
	}
	
}