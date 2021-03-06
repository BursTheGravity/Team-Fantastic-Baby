//Team Fantastic Baby -- Leo Au-Yeung, Sungbin Kim
//Battle.java

public class Battle {
	
    private static String[][] battle;
	
    //default constructor for battle
    public Battle() {
		battle = new String[20][20];
		for ( int row = 0; row < battle.length ; row++ ) {
			for ( int column = 0; column < battle[row].length; column++ ) {
				battle[row][column] = new String();
			}
		}
		//implement how to display battle here
	}//ends Battle()
	
    public static void getBattle() {
		System.out.println( battle );
	}
	
    public static void set( int row, int column, String newVal ) {
		battle[row][column] = newVal;
	}
	
    public static void reset() {
		for ( int row = 0; row < battle.length ; row++ ) {
			for ( int column = 0; column < battle[row].length; column++ ) {
				battle[row][column] = new String();
			}
		}
	}
	
    //toString to return String representation of battle
    public String toString() {
		String retVal = "";
		for ( int row = 0; row < battle.length ; row++ ) {
			for ( int column = 0; column < battle[row].length; column++ ) {
				retVal += battle[row][column];
			}
			retVal += "\n";
		}
		return retVal;
	}//ends toString()
    
}
