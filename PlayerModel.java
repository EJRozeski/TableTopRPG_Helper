
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
	
	public PlayerModel(String name, String race, String pClass, String alignment){
		this.playerStats = new PlayerAttributes();
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
				announceChange(new Object[] {"a", "Strength"});
				break;
			case 'd' :
				playerStats.changeDex(stat);
				announceChange(new Object[] {"a", "Dexterity"});
				break;
			case 'c' :
				playerStats.changeCons(stat);
				announceChange(new Object[] {"a", "Constitution"});
				break;
			case 'i' :
				playerStats.changeIntel(stat);
				announceChange(new Object[] {"a", "Intelligence"});
				break;
			case 'w' :
				playerStats.changeWisdom(stat);
				announceChange(new Object[] {"a", "Wisdom"});
				break;
			case 'C' :
				playerStats.changeCharisma(stat);
				announceChange(new Object[] {"a", "Charisma"});
				break;
		}
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
		announceChange(new Object[] {"i",1});
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
		announceChange(new Object[] {"s",skill});
	}
	
	/*
	 * displaySkills returns an arraylist of skills the character has learned
	 * 	so it can be displayed
	 */
	public void displaySkills(){
		ArrayList<String> skills = playerStats.checkSkills();
		System.out.println("Skills: ");
		int i = 0;
		for(String s : skills){
			System.out.println(s +", ");
			i++;
			if(i > 4){
				System.out.println("\n");
				i = 0;
			}
		}
	}

	/*
	 * changeVitals allows the model to change different stats in the PlayerClass
	 * depending on what parameters identify
	 */
	public void changeVitals(char id, int change){
		switch(id){
			case 'm' :
				playerClass.addHitPoints(change);
				announceChange(new Object[] {"h", change});
				break;
			case 's' :
				playerClass.changeSpeed(change);
				announceChange(new Object[] {});
				break;
			case 'e' :
				playerClass.addExp(change);
				announceChange(new Object[] {"e", change});
				break;
			case 'd' :
				playerClass.changeHitPoints(change);
				announceChange(new Object[] {"h", change});
				break;
			case 'a' :
				playerClass.changeArmor(change);
				announceChange(new Object[] {"r", change});
				break;
		}
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
	
	public void display(){
		String result = "";
		String[] id = getID();
		int[] vit = getVitals();
		int[] stats = playerStats.getStats();
		result += "Name: " + id[0] + "\n";
		result += "Race: " + id[1] + "   Class: " + id[2] + "\n";
		result += "Alignment: " + id[3] + "\n";
		result += "Level: " + vit[0] + "    Experience: " + vit[1] + 
				"HitPoints: " + vit[2] + "\n";
		result += "Armor: " + vit[3] + "    Speed: " + vit[4] + "\n";
		result += "Strength: " + stats[0] + "     Dexterity: " + stats[1] + "\n";
		result += "Constitution: " + stats[2] + "     Intelligence: " + stats[3]
				+ "\n";
		result += "Wisdom: " + stats[4] + "    Charisma: " + stats[5] + "\n";
		result += "Inspiration: " + playerStats.checkInspiration() + "\n";
		System.out.println(result);
		
	}
	
	
	/*
	 * announceChange allows Observers to know Model characteristics have been
	 * 	updated so the display can be updated 
	 */
	private void announceChange(Object[] args){
		setChanged();
		notifyObservers(args);
	}
}
