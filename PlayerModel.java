
import java.util.ArrayList;
import java.util.Observable;

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
	
	public int[] getModifiers(){
		return playerStats.getModifiers();
	}
	
	public void useInspiration(){
		playerStats.UseInspiration();
		announceChange();
	}
	
	public boolean getInspiration(){
		return playerStats.checkInspiration();
	}
	
	public void addSkill(String skill){
		playerStats.addSkill(skill);
		announceChange();
	}
	
	public ArrayList<String> displaySkills(){
		return playerStats.checkSkills();
	}

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
	
	public String[] getID(){
		return playerClass.getID();
	}
	
	public int[] getVitals(){
		return playerClass.getVitals();
	}
	
	public int getDeathSaves(){
		return playerClass.getDeathSaves();
	}
	private void announceChange(){
		setChanged();
		notifyObservers();
	}
}
