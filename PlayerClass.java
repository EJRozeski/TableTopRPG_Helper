
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
	
	public void addHitPoints(int hp){
		maxHitPoints += hp;
		currentHitPoints = maxHitPoints;
	}

	public void changeSpeed(int newSpeed){
		if(newSpeed < MAX_SPEED){
			speed = newSpeed;
		}
		else{
			System.out.println("Speed must be less than: " + MAX_SPEED);
		}
	}
	
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

	public void changeHitPoints(int dmg){
		currentHitPoints -= dmg;
		if(currentHitPoints <= 0){
			System.out.println("Oh No! you are dying, you must use throwing saves.");
			currentHitPoints = 0;
		}
	}

	public void changeArmor(int newArmor){
		armor = newArmor;
		System.out.println("Your armor is now: " + newArmor);
		
	}
	
	public String[] getID(){
		return new String[] {name, race, pClass, alignment};
	}
	
	public int[] getVitals(){
		return new int[] {level, exp, maxHitPoints,currentHitPoints, armor, speed};
	}
	
	public int getDeathSaves(){
		return deathSaveCount;
	}
}
