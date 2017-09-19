import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class PlayerPTUI implements Observer {
	private PlayerModel model;
	
	public PlayerPTUI(int str, int dex, int cos, int intel, int wis, int cha,
						String name, String race, String pClass, String alignment){
		this.model = new PlayerModel(str,dex,cos,intel,wis,cha,name,race,pClass,alignment);
		this.model.addObserver(this);
	}

	public PlayerModel getModel(){
		return this.model;
	}
	
	@Override
	public void update(Observable o, Object arg){
		Object[] array = (Object[]) arg;
		if(array[0].equals("a")){
			System.out.println("Changed " + array[1] + ".");
			model.display();
		}
		if(array[0].equals("i")){
			if(array[1].equals("1")){
				System.out.println("Inspiration Used");
				model.display();
			}
			else{
				System.out.println("Inspiration Added");
				model.display();
			}
		}
		if(array[0].equals("s")){
			System.out.println(array[1]+" added to Skills");
			model.display();
			model.displaySkills();
		}
		if(array[0].equals("h")){
			System.out.println("Hitpoints changed by: "+ array[1]);
			model.display();
		}
		if(array[0].equals("e")){
			System.out.println("Exp added: " + array[1]);
			model.display();
		}
		if(array[0].equals("r")){
			System.out.println("Armor changed to: " + array[1]);
			model.display();
		}
		
	}
}
