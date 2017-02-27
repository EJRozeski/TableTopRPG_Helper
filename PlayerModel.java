
import java.util.ArrayList;
import java.util.Observable;

/*
 * PlayerModel combines multiple classes to create a model that Observers
 * 	can look at to be easily updated
 */
public class PlayerModel extends Observable{
	private PlayerAttributes playerStats;
	private PlayerClass playerClass;
	public String name;
	
	public PlayerModel(int str, int dex, int cos, int intel, int wis, int cha,
						String name, String race, String pClass, String alignment){
		this.playerStats = new PlayerAttributes(str,dex,cos,intel,wis,cha);
		this.playerClass = new PlayerClass(name,race,pClass,alignment);
		this.name = name;
	}
	
	/*
	 * updateStats is a method that protects the underlying class so stats 
	 * 	can be changed from the model
	 */
	public void updateStats(char id, int stat){
		switch(id){
			case 's' :
				playerStats.changeStrength(stat);
				break;
			case 'd' :
				playerStats.changeDex(stat);
				break;
			case 'c' :
				playerStats.changeCons(stat);
				break;
			case 'i' :
				playerStats.changeIntel(stat);
				break;
			case 'w' :
				playerStats.changeWisdom(stat);
				break;
			case 'C' :
				playerStats.changeCharisma(stat);
				break;
		}
		announceChange();
	}
	
	/*
	 * getModifiers calls a function to get the ability modifiers to be displayed
	 * 	in the model
	 */
	public int[] getModifiers(){
		return playerStats.getModifiers();
	}
	
	/*
	 * useInspiration calls an underlying class method and then announces a change
	 * to any observers so its display can be updated 
	 */
	public void useInspiration(){
		playerStats.UseInspiration();
		announceChange();
	}
	
	/*
	 * getInspiration calls a class method to find if the player has any
	 * Inspiration to use so it can be displayed
	 */
	public boolean getInspiration(){
		return playerStats.checkInspiration();
	}
	
	/*
	 * addSkill adds a skill to the Player's skills and announces the change
	 * 	to the observer so it can be displayed
	 */
	public void addSkill(String skill){
		playerStats.addSkill(skill);
		announceChange();
	}
	
	/*
	 * displaySkills returns an arraylist of skills the character has learned
	 * 	so it can be displayed
	 */
	public ArrayList<String> displaySkills(){
		return playerStats.checkSkills();
	}

	/*
	 * changeVitals allows the model to change different stats in the PlayerClass
	 * depending on what parameters identify
	 */
	public void changeVitals(char id, int change){
		switch(id){
			case 'm' :
				playerClass.addHitPoints(change);
				break;
			case 's' :
				playerClass.changeSpeed(change);
				break;
			case 'e' :
				playerClass.addExp(change);
				break;
			case 'd' :
				playerClass.changeHitPoints(change);
				break;
			case 'a' :
				playerClass.changeArmor(change);
				break;
		}
		announceChange();
	}
	
	/*
	 * getID returns an array of Strings so the character's name, class, etc.
	 * 	can be displayed
	 */
	public String[] getID(){
		return playerClass.getID();
	}
	
	/*
	 * getVitals returns an array of int values that correspond to level, exp, etc.
	 * 	to be displayed
	 */
	public int[] getVitals(){
		return playerClass.getVitals();
	}
	
	/*
	 * getDeathsaves returns the deathSaves from the PlayerClass
	 * so it can be displayed
	 */
	public int getDeathSaves(){
		return playerClass.getDeathSaves();
	}
	
	/*
	 * announceChange allows Observers to know Model characteristics have been
	 * 	updated so the display can be updated 
	 */
	private void announceChange(){
		setChanged();
		notifyObservers();
	}
}
