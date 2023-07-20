package myproject;

public class HealingCenter {


	public void run(Character character) {
		character.CharacterInfo();
		System.out.println("Healing Center 입장");
		character.Healing(30);
		System.out.println("체력이 증가합니다");
		character.CharacterInfo();
		System.out.println();
	}
	
}
