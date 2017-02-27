
/*
 * Stat is a simple class that stores an int value that represents
 * 	a character's ability scores
 * @author: Edwin Rozeski
 */
public class Stat {
	
	private int val;
	
	/*
	 * default constructor takes a given value and assigns it to the Stat
	 */
	Stat(int start){
		this.val = start;
	}
	
	/*
	 * simple getter for the val property of the class
	 */
	public int getStat(){
		return val;
	}
	
	/*
	 * simple setter that adds the change to the val
	 * @parameters:
	 * 	change is expected to be a 1 or -1 to increment the val
	 */
	public void changeStat(int change){
		val += change;
		
	}
	
}
