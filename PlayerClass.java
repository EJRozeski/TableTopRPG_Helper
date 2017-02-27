/*
 * PlayerClass is a class full of characteristics a player will immediately create
 * and most will not change as the character progresses through campaigns
 * @author: Edwin Rozeski
 * 
 */
public class PlayerClass {
	public static final int MAX_SPEED = 100;
	private String name;
	private String race;
	private String pClass;
	private String alignment;
	private int exp;
	private int level;
	private int maxHitPoints;
	private int currentHitPoints;
	private int armor;
	private int speed;
	///when deathSaveCount reaches 2, character dies.
	private int deathSaveCount;
	
	/*
	 * Default Constructor takes 4 String parameters that the player can't change
	 * 	once the character is created. The rest of the values are given default values
	 * 	that will be changed as soon as the player has determined them.
	 */
	public PlayerClass(String name, String race, String pClass, String alignment){
		this.name = name;
		this.race = race;
		this.pClass = pClass;
		this.alignment = alignment;
		this.level = 1;
		this.exp = 0;
		this.maxHitPoints = 0;
		this.currentHitPoints = maxHitPoints;
		this.armor = 15;
		this.speed = 25;
		this.deathSaveCount = 0;
	}
	
	/*
	 * addHitPoints adds to the maxHitPoints according to the parameter hp
	 */
	public void addHitPoints(int hp){
		maxHitPoints += hp;
		currentHitPoints = maxHitPoints;
	}

	/*
	 * changeSpeed checks to make sure the new speed is less than the max, and
	 * changes it
	 */
	public void changeSpeed(int newSpeed){
		if(newSpeed < MAX_SPEED){
			speed = newSpeed;
		}
		else{
			System.out.println("Speed must be less than: " + MAX_SPEED);
		}
	}
	
	/*
	 * addExp contains an array of the level thresholds for Dungeons and 
	 * 	Dragons 5e levels and will change the level if the player has passed
	 * 	a threshold, displaying a message if so.
	 */
	public void addExp(int add){
		int[] thresholds = {0,300,900,2700,6500,14000,23000,34000,48000,64000,
							85000,100000,120000,140000,165000,195000,225000,
							265000,305000,355000};
		exp = exp + add;
		if(exp >= thresholds[level]){
			level++;
			System.out.println("To Glory! You have leveled up.");
		}
	}

	/*
	 * changeHitPoints changes currentHitPoints when damage is taken
	 * 	The player is notified if they have reached 0 hitPoints
	 */
	public void changeHitPoints(int dmg){
		currentHitPoints -= dmg;
		if(currentHitPoints <= 0){
			System.out.println("Oh No! you are dying, you must use throwing saves.");
			currentHitPoints = 0;
		}
	}

	/*
	 * changeArmor changes the armor level of the character
	 */
	public void changeArmor(int newArmor){
		armor = newArmor;
		System.out.println("Your armor is now: " + newArmor);
		
	}
	
	/*
	 * getID returns the defining characteristics of the character
	 * 	Will be used for displaying in a GUI or PTUI interface
	 */
	public String[] getID(){
		return new String[] {name, race, pClass, alignment};
	}
	
	/*
	 * getVitals returns the number characteristics of a character
	 * 	Will be used for display
	 */
	public int[] getVitals(){
		return new int[] {level, exp, maxHitPoints,currentHitPoints, armor, speed};
	}
	
	/*
	 * getDeathSaves returns the deathSaveCount variable
	 * 	Will be used for display
	 */
	public int getDeathSaves(){
		return deathSaveCount;
	}
}
