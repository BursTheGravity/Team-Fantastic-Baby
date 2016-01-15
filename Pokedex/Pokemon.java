//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pokemon.java
package Pokedex;

public abstract class Pokemon {
	
    //mother class governing all Pokemon in the game
    protected boolean wild = true; //boolean for if pkmn is wild or a Trainer's
    protected String name, type; //will we let type change?
    protected int currentHP, maxHP, attack, defense, speed, level;
    protected double exp;
    protected String[] weaknesses, strengths;
    protected String[] movesName;
    protected Integer[] movesDmg;
    //if move is type weak, more dmg. if move is type strength, less dmg
	
    //Constructor
    public Pokemon ( String n, int hp, int atk, int def, int spd, int lvl, String t ) {
	name = n;
	maxHP = hp;
	currentHP = maxHP;
	attack = atk;
	defense = def;
	speed = spd;
	level = lvl;
	exp = 0;
	type = t;
    }
	
    //Mutators
    public void setWild ( boolean w ) { wild = w; }
    public void setName ( String n ) { name = n; }
    public void setType ( String t ) { type = t; }
    public void setHP ( int hp ) { currentHP = hp; }
    public void setAttack ( int atk ) { attack = atk; }
    public void setDefense ( int def ) { defense = def; }
    public void setSpeed ( int spd ) { speed = spd; }
    public void setLevel ( int lvl ) { level = lvl; }
    public void setEXP ( double xp ) { exp = xp; }
	
    public boolean fainted() { return currentHP > 0; }
	
    //Accessors
    public boolean getWild() { return wild; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getHP() { return currentHP; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public int getLevel() { return level; }
    public double getEXP() { return exp; }
	
    //Battle methods
    public int attack (Pokemon enemy, int move) {
	int damage = ( ( (2 * level + 10) / 250 ) * ( attack / enemy.getDefense() ) * movesDmg[move] + 2 );
	//actual formula for dmg in Pokemon
	enemy.setHP ( enemy.getHP() - damage );
	return damage;
    }

    /*
    // i think this is good? movename can be displayed in the battle mode and when the user chooses a move we can refer to these methods below.
    public int skill1() {/*implementation in subclasses}
    public int skill2() {}
    public int skill3() {}
    public int skill4() {}*/
	
    //description of Pokemon
    public abstract String about();
	
}
