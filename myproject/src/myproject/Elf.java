package myproject;


public class Elf  extends Character{
	
	Skill skill = new Skill("매직 미사일",0,1,15);
	static Character character = Elf.singleton();
	
	public Elf() {
		this.name = "엘프";
	
		this.sp = 70;
		super.SkillList.add(skill);
		super.SkillList.add(new Skill("파이어 에로우",10,2,30));
		super.SkillList.add(new Skill("라이트닝볼트",20,3,45));
		super.SkillList.add(new Skill("블리자드",30,4,60));
		super.SkillList.add(new Skill("메테오",50,5,99999));
	}
	public Elf(String name, int n1,int n2,int n3,int n4,int n5,int n6, int n7, int n8) {
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
		super.SkillList.add(new Skill("파이어 에로우",10,2,30));
		super.SkillList.add(new Skill("라이트닝볼트",20,3,45));
		super.SkillList.add(new Skill("블리자드",30,4,60));
		super.SkillList.add(new Skill("메테오",50,5,99999));
	
	}
	@Override
	public void Levelup() {
		if(charge == 3) {
		maxHp +=5;
		
		charge = 0;
		level +=1;
		damage += 5; 
		hp += 5;
		System.out.println("레벨업 하셨습니다");
		System.out.println("현재 레벨:"+ getLevel());
		
		}
		
		
	}
	
	
	public static Character singleton() {
		
		
		return character;
	}
	@Override
	public void FightingEnd() {
		if(maxHp<this.hp+5)
		{
			hp=maxHp;
		}
		else {
			this.hp += 5;
		}
		if(maxSp<this.sp+10)
		{
			sp=maxSp;
		}
		else {
			this.sp += 10;
		}
		
	}
	@Override
	public void GainEquiqment()
	{
		for(Item i :itemlist) {
			if(i.getName().equals(ItemName.Bow.toString())){
				int damage1 = getDamage()+20;
				setDamage(damage1);
			}
			
		}
		
	}
	
}

