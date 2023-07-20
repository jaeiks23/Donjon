package myproject;

import java.util.ArrayList;

import myproject.Character.Skill;

public class Oak extends Character {
	
	
	Skill skill = new Skill();
	static Character character = Oak.singleton();
	ArrayList<Skill>SkillList = new ArrayList<>();
	
	public Oak() {
		this.name = "오크";
		super.SkillList.add(skill);
		super.SkillList.add(new Skill("힘껏 휘두루기",10,2,20));
		super.SkillList.add(new Skill("마구 휘두루기",15,3,30));
		super.SkillList.add(new Skill("태산 날리기",20,4,40));
		super.SkillList.add(new Skill("신 죽이기",50,5,99999));
		
		
	}
	public Oak(String name, int n1,int n2,int n3,int n4,int n5,int n6, int n7, int n8) {
		this.name = name;
		this.maxHp = n1;
		this.maxSp = n2;
		this.hp = n3;
		this.sp = n4;
		this.damage = n5;
		this.level  = n6;
		this.charge = n7;
		this.escape = n8;
		super.SkillList.add(skill);
		super.SkillList.add(new Skill("힘껏 휘두루기",10,2,20));
		super.SkillList.add(new Skill("마구 휘두루기",15,3,30));
		super.SkillList.add(new Skill("태산 날리기",20,4,40));
		super.SkillList.add(new Skill("신 죽이기",50,5,99999));
		
	}
	@Override
	public void Levelup() {
		if(charge == 3) {
		maxHp +=10;
		
		charge = 0;
		level +=1;
		damage += 7; 
		hp += 10;
		System.out.println("레벨업 하셨습니다");
		System.out.println("현재 레벨:"+ getLevel());
	
		}
		
		
	}

	public static Character singleton() {
		
		
		return character;
	}
	@Override
	public void FightingEnd() {
		if(maxHp<this.hp+10)
		{
			hp=maxHp;
		}
		else {
			this.hp += 10;
		}
		if(maxSp<this.sp+5)
		{
			sp=maxSp;
		}
		else {
			this.sp += 5;
		}
		
	}
	@Override
	public void GainEquiqment()
	{
		for(Item i :itemlist) {
			if(i.getName().equals(ItemName.Club.toString())){
				int damage1 = getDamage()+20;
				setDamage(damage1);
			}
			
		}
		
	}
	
		
	
}

