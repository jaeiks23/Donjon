package myproject;

import java.util.Scanner;

public class Boss extends Monster{
	
	Scanner sc = new Scanner(System.in);
	int bras = 1;
	public Boss() {
		super(1,"흑룡", 150, 40);
		
	}
	public void BossSkill(Character character) {
		if(bras ==1 )
		{
		System.out.println(this.name+ "이 브레스를 쏩니다");
		character.setHp();
		}
		
	}
	
	public void setbras() {
		this.bras--;
	}
	@Override
	public void ShowMonster() {
		System.out.print(getNumber() +"."+getName() +" hp: "+ getHp() +"  데미지 : "+ this.getDamage());
		System.out.println();
	}
	@Override
	public void Skill(Character character) {
		BossSkill(character);
		this.bras--;
		
	}
	
	
	
	

	
}	

