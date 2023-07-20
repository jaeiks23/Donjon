package myproject;


public class Human extends Character{
	
	Skill skill = new Skill("한손 베기",0,1,10);
	static Character character = Human.singleton();
	
	public Human() {
		this.name = "인간";
		
		this.sp =  40;
		super.SkillList.add(skill);
		super.SkillList.add(new Skill("번개베기",10,2,20));
		super.SkillList.add(new Skill("회전베기",15,3,30));
		super.SkillList.add(new Skill("신검합일",20,4,40));
		super.SkillList.add(new Skill("승천",50,5,99999));
	}
	public Human(String name, int n1,int n2,int n3,int n4,int n5,int n6, int n7, int n8) {
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
		super.SkillList.add(new Skill("번개베기",10,2,20));
		super.SkillList.add(new Skill("회전베기",15,3,30));
		super.SkillList.add(new Skill("신검합일",20,4,40));
		super.SkillList.add(new Skill("승천",50,5,99999));
	}
	@Override
	public void Levelup() {
		if(charge == 3) {
		maxHp +=6;
		
		charge = 0;
		level +=1;
		damage += 6; 
		hp += 7;
		System.out.println("레벨업 하셨습니다");
		System.out.println("현재 레벨:"+ getLevel());
		
		}
		
	}
	
	public static Character singleton() {
		
		
		return character;
	}
	@Override
	public void FightingEnd() {
		if(maxHp<this.hp+7)
		{
			hp=maxHp;
		}
		else {
			this.hp += 7;
		}
		if(maxSp<this.sp+7)
		{
			sp=maxSp;
		}
		else {
			this.sp += 7;
		}
		
	}
	@Override
	public void GainEquiqment()
	{
		for(Item i :itemlist) {
			if(i.getName().equals(ItemName.Sword.toString())){
				int damage1 = getDamage()+20;
				setDamage(damage1);
			}
			
		}
		
	}
	
}

