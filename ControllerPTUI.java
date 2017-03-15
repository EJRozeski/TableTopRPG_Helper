import java.util.Scanner;

public class ControllerPTUI {
	private PlayerModel model;
	
	public static PlayerClass newHero(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a name for your Hero: ");
		String name = sc.nextLine();
		System.out.println("What is your race?: ");
		String race = sc.nextLine();
		System.out.println("What is your class?: ");
		String clas = sc.nextLine();
		System.out.println("What is your alignment?: ");
		String align = sc.nextLine();
		System.out.println("Welcome " + name);
		PlayerClass res = new PlayerClass(name,race,clas,align);
		return res;	
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you a returning Hero? (yes/no)");
		String hero = sc.nextLine();
		if(hero.equals("no")){
			PlayerClass playr = newHero();
		}
		while(true){
			break;
		}
		sc.close();
	}
}
