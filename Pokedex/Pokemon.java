//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Pokemon.java
package Pokedex;

import java.util.ArrayList;

public abstract class Pokemon {
	
    //mother class governing all Pokemon in the game
    protected boolean wild; //boolean for if pkmn is wild or a Trainer's
    protected String name, type;
    protected int HP, maxHP, attack, baseAttack, defense, baseDefense, speed, level, exp, levelEXP;
	//Types: Normal, Fighting, Flying, Grass, Fire, Water, Electric, Rock, Ice, Dark, Steel
    protected ArrayList weaknesses = new ArrayList();
	protected ArrayList strengths = new ArrayList();
    protected int movesNum;
    protected String[] movesName = {"None","None","None","None"};
    protected Integer[] movesDmg = {40,75,90,120}; //hard coded damage for all moves
	//same PP for all Pokemon
    protected Integer[] PP = {25,15,10,5};
    protected Integer[] maxPP = {25,15,10,5};
	
    //Constructor
    public Pokemon() {
		name = "None";
		maxHP = 0;
		HP = 0;
		level = 0;
		type = "NONE";
	}
	
	//Constructor with varying level
    public Pokemon ( String n, int lvl, String t ) {
		//hard coded formulas of Pokemon stats for all Pokemon
		name = n;
		level = lvl;
		normalize();
		HP = maxHP;
		exp = 0;
		attack = baseAttack;
		defense = baseDefense;
		type = t;
		addWeaknesses();
		addStrengths();
	}
	
	//Mutators
	public void setWild ( boolean w ) { wild = w; }
	public void setName ( String n ) { name = n; }
	public void setType ( String t ) { type = t; }
	public void setHP ( int hp ) { HP = hp; }
	public void setMaxHP ( int hp ) { maxHP = hp; }
	public void setAttack ( int atk ) { attack = atk; }
	public void setDefense ( int def ) { defense = def; }
	public void setSpeed ( int spd ) { speed = spd; }
	public void setLevel ( int lvl ) { level = lvl; }
	public void setLevelEXP ( int lvlxp ) { levelEXP = lvlxp; }
	public void setEXP ( int xp ) { exp = xp; }
	public void setMoves ( int mvs ) { movesNum = mvs; }
	
	//Accessors
	public boolean getWild() { return wild; }
	public String getName() { return name; }
	public String getType() { return type; }
	public int getHP() { return HP; }
	public int getMaxHP() { return maxHP; }
	public int getAttack() { return attack; }
	public int getDefense() { return defense; }
	public int getSpeed() { return speed; }
	public int getLevel() { return level; }
	public int getLevelEXP() { return levelEXP; }
	public int getEXP() { return exp; }
	public int getMovesNum() { return movesNum; }
	public String getMovesName( int n ) { return movesName[n]; }
	public int getPP( int n ) {
		if (movesNum >= n) { return PP[n];}
		else { return 0; }
		}
	public int getMaxPP( int n ) {
		if (movesNum >= n) { return maxPP[n]; }
		else { return 0; }
	}
	
	public boolean fainted() { return HP > 0; }
	
	//leveling up & setting stats
	public void levelUp() {
		while (exp > levelEXP) {
			level += 1;
			System.out.println(name + " grew to Lv. " + level + "!");
			normalize();
		}
	}
	
	//Formulas for stats: http://bulbapedia.bulbagarden.net/wiki/Statistic#In_Generation_III_onward
	public void normalize() {
		maxHP = (int) ( (2 * 45 * level) / 100) + level + 10;
		baseAttack = (int) ( (2 * 50 * level) / 100 ) + 5;
		baseDefense = (int) ( (2 * 45 * level) / 100 ) + 5;
		speed = (int) ( (2 * 45 * level) / 100 ) + 5;
		levelEXP = (level * level * level) - ((level - 1) * (level - 1) * (level - 1));
	}
	
	//Adding moves
	//Lists of moves from: http://pokemondb.net/move/all
    public void addMove( String move ) {
		movesName[movesNum] = move;
		movesNum += 1;
	}
	
	//Types: Normal, Fire, Water, Electric, Grass, Ice, Fighting, Flying, Rock, Dark, Steel
	
	public void addWeaknesses() {
		if ( type.equals("NORMAL") ) { weaknesses.add("ROCK"); weaknesses.add("STEEL"); }
		else if ( type.equals("FIRE") ) { weaknesses.add("FIRE"); weaknesses.add("WATER"); weaknesses.add("ROCK"); }
		else if ( type.equals("WATER") ) { weaknesses.add("WATER"); weaknesses.add("GRASS"); }
		else if ( type.equals("ELECTRIC") ) { weaknesses.add("ELECTRIC"); weaknesses.add("GRASS"); }
		else if ( type.equals("GRASS") ) { weaknesses.add("FIRE"); weaknesses.add("GRASS"); weaknesses.add("FLYING"); }
		else if ( type.equals("ICE") ) { weaknesses.add("FIRE"); weaknesses.add("WATER"); weaknesses.add("ICE"); weaknesses.add("STEEL");}
		else if ( type.equals("FIGHTING") ) { weaknesses.add("FLYING"); }
		else if ( type.equals("FLYING") ) { weaknesses.add("ELECTRIC"); weaknesses.add("ROCK"); }
		else if ( type.equals("ROCK") ) { weaknesses.add("FIGHTING"); weaknesses.add("STEEL"); }
		else if ( type.equals("DARK") ) { weaknesses.add("FIGHTING"); weaknesses.add("DARK"); }
		else if ( type.equals("STEEL") ) { weaknesses.add("FIRE"); weaknesses.add("WATER"); weaknesses.add("ELECTRIC"); weaknesses.add("STEEL"); }
	}
	
	public void addStrengths() {
		if ( type.equals("NORMAL") ) { strengths.add("NONE"); }
		else if ( type.equals("FIRE") ) { strengths.add("GRASS"); strengths.add("ICE"); strengths.add("STEEL"); }
		else if ( type.equals("WATER") ) { strengths.add("FIRE"); strengths.add("ROCK"); }
		else if ( type.equals("ELECTRIC") ) { strengths.add("WATER"); strengths.add("FLYING"); }
		else if ( type.equals("GRASS") ) { strengths.add("WATER"); strengths.add("ROCK"); }
		else if ( type.equals("ICE") ) { strengths.add("GRASS"); strengths.add("FLYING"); }
		else if ( type.equals("FIGHTING") ) { strengths.add("NORMAL"); strengths.add("ICE"); strengths.add("ROCK"); strengths.add("STEEL"); }
		else if ( type.equals("FLYING") ) { strengths.add("GRASS"); strengths.add("FIGHTING"); }
		else if ( type.equals("ROCK") ) { strengths.add("FIRE"); strengths.add("ICE"); strengths.add("FLYING"); }
		else if ( type.equals("DARK") ) { strengths.add("NONE"); }
		else if ( type.equals("STEEL") ) { strengths.add("ICE"); strengths.add("ROCK"); }
	}
	
	public boolean hasWeak ( String s ) {
		for ( int i = 0; i < weaknesses.size(); i++ ) {
			if ( (weaknesses.get(i)).equals(s) ) { return true; }
		}
		return false;
	}
	
	public boolean hasStr ( String s ) {
		for ( int i = 0; i < strengths.size(); i++ ) {
			if ( (strengths.get(i)).equals(s) ) { return true; }
		}
		return false;
	}
	
	//Battle methods
	public void attack (Pokemon enemy, int n) {
		int move = n - 1;
		
		double effectiveness = 1;
		if ( hasWeak( enemy.getType() ) ) { effectiveness = 0.5; }
		else if ( hasWeak( enemy.getType() ) ) { effectiveness = 2; }
		int baseDmg = movesDmg[move];
		
		//actual formula for dmg in Pokemon; http://bulbapedia.bulbagarden.net/wiki/Damage#Damage_formula
		int damageDealt = (int) ( ( ( (2 * getLevel() + 10) / 250 ) * ( getAttack() / enemy.getDefense() ) * baseDmg + 2 ) * effectiveness );
		
		enemy.lowerHP(damageDealt);
		PP[move] -= 1;
	}
	
	public void resetStats() {
		attack = baseAttack;
		defense = baseDefense;
	}
	
	public void restoreHP( int amount ) {
		setHP ( HP + amount );
		if ( HP > maxHP ) { HP = maxHP; }
	}
	
	public void lowerHP( int amount ) {
		setHP ( HP - amount );
		if ( HP < 0 ) { HP = 0; }
	}
	
	public void restorePP( int amount ) {
		for ( int i = 0; i < movesNum; i++ ) {
			PP[i] = PP[i] + amount;
			if ( PP[i] > maxPP[i] ) { PP[i] = maxPP[i]; }
		}
	}
	
	public boolean allMaxPP() {
		for ( int i = 0; i < movesNum; i++ ) {
			if ( PP[i] < maxPP[i] ) { return false; }
		}
		return true;
	}
	
	//description of Pokemon
	public abstract String about();
	
	}
	
