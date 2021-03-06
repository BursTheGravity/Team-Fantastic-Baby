//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Charmander.java
package Pokedex;

public class Charmander extends Pokemon {
	
	//Constructor
	public Charmander() {
		super("Charmander", 5, 16, "FIRE");
		addMove("Ember");
		addMove("Fire Punch");
	}
	
	//Constructor for trainers
	public Charmander( int lvl ) {
		this();
		level = lvl;
	}
	
	//Constructor for evolutions
	public Charmander( String n, int lvl, int eLvl) {
		super( n, lvl, eLvl, "FIRE");
		addMove("Ember");
		addMove("Fire Punch");
	}
	
	//Pokedex description
	public String about() {
		return "The flame that burns at the tip of its tail is an indication of its emotions. \n" +
		"The flame wavers when Charmander is enjoying itself. \n" +
		"If the Pokemon becomes enraged, the flame burns fiercely.";
	}
	
}
