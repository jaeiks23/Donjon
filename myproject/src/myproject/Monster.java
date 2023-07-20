package myproject;

public class Monster {
	
	String name;
	int hp;
	int damage;
	int number;
	private static int nextnumber = 0;
	
	public Monster(int number,String name,int hp,int damage)
	{
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		
		this.number = number;
	}
	
	public int getDamage() {
		return damage;
	}
	public void ShowMonster() {
		System.out.print(getNumber() +"."+getName() +" hp: "+ getHp() +"  데미지: "+ this.getDamage());
		System.out.println();
	}

	public int getHp() {
		return hp;
	}
	public String getName() {
		return this.name;
	}

	public void decreaseHp(int damage) {
		this.hp -= damage;
		System.out.println(getName()+"가 데미지를 "+ damage+" 받았습니다" );
	}
	public void setNumber(int num)
	{
		this.number = num;
	}
	public int getNumber()
	{
		return this.number;
	}
	public void setNextNumber() {
		nextnumber  = 0;
	}
	public void Skill(Character character)
	{
		
	}
	
}
