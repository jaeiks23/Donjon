package myproject;

import java.util.Scanner;

public class Donjon {
	
	
	Scanner sc = new Scanner(System.in);
	String name;
	
	public Donjon() {
		
		
		
	}
	public String getName() {
		return name;
	}
	public void SetName(String name) {
		this.name = name;
	}
	
	public void run3(Character character) {
		Donjon donjon = new Donjon();
		String name1 = "";
		int random = (int)(Math.random()*4)+1;
		for(DonjonName d: DonjonName.values()) {
			if(d.getnumber()==random) {
				name1 = d.name().toString();
			}
		}
		donjon.SetName(name1);
		
		System.out.println("던전에 들어섰습니다");
		System.out.println("들어가지려면 1번, 도망가시려면 2번을 눌러주십시요");
		int num = sc.nextInt();
		if(num==1) {
			System.out.println(donjon.getName() +"던전에 입장하셨습니다");
			switch(donjon.getName()) {
			case "LEVELUP":
				for(int i=0;i<6;i++)
				{
					character.IncreaseCharger();
				}
				break;
			case "HEALING":
				character.hp = character.maxHp;
				System.out.println("최대 체력까지 회복합니다");
				break;
			case "POSION":
				character.getItem(new Item("escape 포션"));
				System.out.println("escape 포션 획득!");
				break;
			case "EQUIPMENT":
				for(ItemName it: ItemName.values()) {
					if(it.getName().equals(character.getName())) {
						character.itemlist.add(new Item(it.toString()));
						character.GainEquiqment();
						System.out.println(it.toString());
					}
				}
				break;
				
			case "DEATH":
				character.heating(999999);
				
				break;
			}
		}
		else {
			System.out.println("성공적으로 나왔습니다");
		}
		
		
		
	}
	
	
	
	
	
}
