
public class Stat {
	
	private int val;
	
	Stat(int start){
		this.val = start;
	}
	
	public int getStat(){
		return val;
	}
	
	public void changeStat(int change){
		val += change;
		
	}
	
}
