import java.util.ArrayList;
import java.util.Random;

public class PlayerAttributes {
	private Stat strength;
	private Stat dexterity;
	private Stat cons;
	private Stat intel;
	private Stat wisdom;
	private Stat charisma;
	private boolean inspiration;
	private ArrayList<String> skills;
	
	public PlayerAttributes(){
		this.strength = new Stat(randomStat());
		this.dexterity = new Stat(randomStat());
		this.cons = new Stat(randomStat());
		this.intel = new Stat(randomStat());
		this.wisdom = new Stat(randomStat());
		this.charisma = new Stat(randomStat());
		this.inspiration = false;
		this.skills = new ArrayList<String>();
	}

	public PlayerAttributes(int strength, int dexterity, int cons, int intel,
			int wisdom, int charisma){
		this.strength = new Stat(strength);
		this.dexterity = new Stat(dexterity);
		this.cons = new Stat(cons);
		this.intel = new Stat(intel);
		this.wisdom = new Stat(wisdom);
		this.charisma = new Stat(charisma);
		this.inspiration = false;
		this.skills = new ArrayList<String>();
	}

	public static int randomStat(){
		Random rand = new Random();
	    int randomNum = rand.nextInt(18 - 1) + 1;
		    return randomNum;
	}

	public void changeStrength(int num){
		strength.changeStat(num);
	}
	public void changeDex(int num){
		dexterity.changeStat(num);
	}
	public void changeCons(int num){
		cons.changeStat(num);
	}
	public void changeIntel(int num){
		intel.changeStat(num);
	}
	public void changeWisdom(int num){
		wisdom.changeStat(num);
	}
	public void changeCharisma(int num){
		charisma.changeStat(num);
	}
	
	private int abilityModifier(Stat stat){
		int temp;
		int res;
		int mod;
		int ability = stat.getStat();
		if(ability == 0){
			return 0;
		}
		else if(ability < 10){
			if(ability == 1){
				return -5;
			}
			else if(ability == 2 || ability == 3){
				return -4;
			}
			else if(ability == 4 || ability == 5){
				return -3;
			}
			else if(ability == 6 || ability == 7){
				return -2;
			}
			else if(ability == 8 || ability == 9){
				return -1;
			}
		}
		else{
			mod = ability % 10;
			temp = (ability / 10) - 1;
			if(mod % 2 == 1){
				mod--;
			}
			res = mod / 2;
			if(temp > 0){
				res += (temp * 5);
			}
			return res;
		}
		return 0; //unreachable but only to catch errors in if statements.
	}
	
	public int[] getModifiers(){
		int[] res = new int[6];
		int mod;
		mod = abilityModifier(strength);
		res[0] = mod;
		mod = abilityModifier(dexterity);
		res[1] = mod;
		mod = abilityModifier(cons);
		res[2] = mod;
		mod = abilityModifier(intel);
		res[3] = mod;
		mod = abilityModifier(wisdom);
		res[4] = mod;
		mod = abilityModifier(charisma);
		res[5] = mod;
		return res;
	}
	
	public int[] getStats(){
		return new int[] {strength.getStat(),dexterity.getStat(),cons.getStat()
		                  ,intel.getStat(),wisdom.getStat(),charisma.getStat()};
	}
	
	public void UseInspiration(){
		inspiration ^= true;
	}

	public boolean checkInspiration(){
		return inspiration;
	}

	public void addSkill(String skill){
		skills.add(skill);
	}
	public ArrayList<String> checkSkills(){
		return skills;
	}


}
