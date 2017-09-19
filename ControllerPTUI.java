import java.util.Scanner;

public class ControllerPTUI {
	private static PlayerModel model;


	public static void newHero(Scanner sc){
		System.out.println("Enter a name for your Hero: ");
		String name = sc.nextLine();
		System.out.println("What is your race?: ");
		String race = sc.nextLine();
		System.out.println("What is your class?: ");
		String clas = sc.nextLine();
		System.out.println("What is your alignment?: ");
		String align = sc.nextLine();
		System.out.println("Welcome " + name + "\n Rolling random stats...");
		model = new PlayerModel(name,race,clas,align);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you a returning Hero? (yes/no)");
		String resp = sc.nextLine();
		if(resp.equals("no")){
			newHero(sc);
		}
		while(true){

			break;
		}
		model.display();
		sc.close();
	}
}
