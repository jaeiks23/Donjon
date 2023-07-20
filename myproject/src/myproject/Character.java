package myproject;

import java.util.ArrayList;



public class Character {
		
		public  ArrayList<Skill>SkillList = new ArrayList<>();
		ArrayList<Item>itemlist = new ArrayList<>();
	
		
		String name;
		int maxHp;
		int maxSp;
		int hp;
		int sp;
		int damage;
		int level;
		int charge;
		int escape = 0;
		boolean alive = true;
		Skill skill = new Skill();
		public Character(String name, int n1,int n2,int n3,int n4,int n5,int n6, int n7, int n8) {
			this.name = name;
			this.maxHp = n1;
			this.maxSp = n2;
			this.hp = n3;
			this.sp = n4;
			this.damage = n5;
			this.level  = n6;
			this.charge = n7;
			this.escape = n8;
			
		}
		public ArrayList<Item> getItemlist() {
			return itemlist;
		}
		public void setItemlist(ArrayList<Item> itemlist) {
			this.itemlist = itemlist;
		}
		public Character() {
			name = "Character";
			maxHp = 100;
			maxSp = 50;
			hp = 100;
			sp = 50;
			damage = 5; 
			level =1;
			charge = 0;
			
			itemlist.add(new Item("hp 포션"));
			itemlist.add(new Item("hp 포션"));
			itemlist.add(new Item("escape 포션"));
			
		}
		public int getEscape() {
			return escape;
		}
		public void setEscape(int escape) {
			this.escape = escape;
		}
		public void Levelup() {
			if(charge == 4) {
			maxHp +=10;
			
			charge = 0;
			level +=1;
			damage += 5; 
			hp += 10;
			System.out.println("레벨업 하셨습니다");
			System.out.println("Level:"+ getLevel());
		
			}
			
			
		}
		public ArrayList<Skill> getSkillList() {
			return SkillList;
		}
		public void setSkillList(ArrayList<Skill> skillList) {
			SkillList = skillList;
		}
		public int getMaxHp() {
			return maxHp;
		}
		public void setMaxHp(int maxHp) {
			this.maxHp = maxHp;
		}
		public int getMaxSp() {
			return maxSp;
		}
		public void setMaxSp(int maxSp) {
			this.maxSp = maxSp;
		}
		public boolean getalive() {
			return alive;
		}
		public String getName() {
			return name;
		}
		public int getLevel() {
			return this.level;
		}
		
		public int getCharge()
		{
			return this.charge;
		}
		public void heating(int damage)
		{
			this.hp -=damage;
		}
		public void CharacterAllInfo() {
			System.out.println("종족명: :" + name);
			System.out.println("Level: " + level+" damage: "+damage );
			System.out.println("Hp: " + hp+"/"+maxHp+" Sp: "+sp );
			int continueCharge = 4-getCharge();
			System.out.println("레벨업까지 남은 몬스터의 수:" +continueCharge);
			System.out.println();
		}
		public int getSp() {
			return this.sp;
		}
		public void CharacterInfo(){
		System.out.println("종족: "+getName() +" Hp: " + getHp()+"/"+maxHp+" Sp: "+getSp() +"/"+maxSp);
			
		}
		public boolean Healing() {
			if(maxHp == hp)
			{
				System.out.println("최대 체력입니다 포션을 사용하실수 없습니다.");
				return false;
			}
			else if(maxHp<(hp+20))
			{
				hp = maxHp;
				return true;
			}
			this.hp  += 20;
			return true;
		}
		public void Healing(int num) {
			
			
			this.hp  += num;
			this.maxHp +=num;
		}
		public void ShowanddecreaseSp( ) {
			if(getLevel()>7) {
				
				for(Skill s: SkillList)
				{	
					
					System.out.println(s.num+"."+s.getName()+" Damage: "+ (s.getDamage()+this.getDamage()) +"(SP:"+s.sp +")");
					
				}
				
			}
			else if(getLevel()>4) {
				
				for(Skill s: SkillList)
				{	
					if(s.getNum() <5 )
					{
					System.out.println(s.num+"."+s.getName()+" Damage: "+ (s.getDamage()+this.getDamage()) +"(SP:"+s.sp +")");
					}
				}
				
			}
			else if(getLevel()>2) {
				
				for(Skill s: SkillList)
				{	
					if(s.getNum() <4)
					{
					System.out.println(s.num+"."+s.getName()+" Damage: "+ (s.getDamage()+this.getDamage()) +"(SP:"+s.sp +")");
					}
				}
				
			}
			else if(getLevel()>1) {
				
				for(Skill s: SkillList)
				{	
					if(s.getNum() <3)
					{
					System.out.println(s.num+"."+s.getName()+" Damage: "+ (s.getDamage()+this.getDamage()) +"(SP:"+s.sp +")");
					}
				}
				
			}
			else { 
				for(Skill s: SkillList)
				{	
					if(s.getNum() <2)
					{
					System.out.println(s.num+"."+s.getName()+" Damage: "+ (s.getDamage()+this.getDamage()) +"(SP:"+s.sp +")");
					}
				}
			}
			
		}
		
		public int getHp() {
			return this.hp;
		}
		public int selectSkill(int num) {
			if(getLevel()<2)
			{
				if(num>=2) {
					System.out.println("UnLock");
					return 0;
				}
			}
			else if(getLevel()<3) {
				if(num>2) {
					System.out.println("UnLock");
					return 0;
				}
			}
			else if(getLevel()<4) {
				if(num>3) {
					System.out.println("UnLock");
					return 0;
				}
			}
			else if(getLevel()<6) {
				if(num>4) {
					System.out.println("UnLock");
					return 0;
				}
			}
			
			for(Skill s: SkillList)
			{
				if(sp>=s.sp) {
				if(s.getNum() == num)
				{
					
					if(s.getNum() == 5)
					{
						System.out.println(name+"가"+ s.getName()+"스킬을 실행하셨습니다");
						this.sp = this.sp -s.sp;
						return s.getDamage()+this.getDamage();
						
					}
					System.out.println(name+"가 "+ s.getName()+"스킬을 실행하셨습니다");
					this.sp = this.sp -s.sp;
					return s.getDamage()+this.getDamage();
				}
						
				}
				else {
					System.out.println("sp가 부족합니다");
					return 0;
				}
			}
			System.out.println("UnLock");
			return 0;
		}

		public void CharacterAlive() {
			if(getHp()>0) {
				 alive = true;
			}
			else {
				 alive = false;
			}
			
		}
		public void setAlive() {
			this.alive = true;
		}
		
		public void UseHpposion(int number) {
			int num  = number-1;
			if(itemlist.size()>=number)
			{
				Item i = itemlist.get(num);
				
				
				
				
				if(i.getName().equals("escape 포션")){
					this.escape += 1;
					i.UseItem();
					itemlist.remove(i);
					System.out.println("다음 공격을 한 번 회피합니다");
					return;
				}
				else if(i.getName().equals("Club"))
				{
					System.out.println("사용할수 없는 아이템입니다");
				}
				if(Healing())
				{
					i.UseItem();
					itemlist.remove(i);
					
				}
				return;
			}
			System.out.println("잘못 입력하셨습니다");
			
		}
		public boolean CheckEscape() {
			if(this.escape==1)
			{
				
				escape --;
				return true;
			}
			return false;
		}
				
		
		
		

		
		public void getItem(Item item) {
			itemlist.add(item);
			
		}
		public void removeItem(String nam) {
			for(Item i :itemlist) {
				if(i.getName().equals(nam)){
						itemlist.remove(i);
						System.out.println("성공적으로 제거하셨습니다");
						return;
				}
				
				
			}
			System.out.println("삭제하실 아이템이 없는거 같습니다");
		}
		
		public void GainEquiqment()
		{
			for(Item i :itemlist) {
				if(i.getName().equals(ItemName.Club.toString())){
					int damage1 = getDamage()+20;
					setDamage(damage1);
				}
				
			}
			
		}
		public void ShowItemList() {
		
			System.out.println("▷▷▷▷▷▷▷▷▷▷▷▷▷Item◁◁◁◁◁◁◁◁◁◁◁◁◁");
			for(Item i :itemlist) {
				System.out.print((itemlist.indexOf(i)+1) +".");
				i.Iteminfo();
				
			}
		}
		public void IncreaseCharger() {
			charge++;
			Levelup();
		}
		
		public int getDamage() {
			return this.damage;
		}
		public void setDamage(int damage) {
			this.damage = damage;
		}

		
		
		public void setHp() {
			
			this.hp = (int)(this.hp*0.1);
		}
		public void FightingEnd() {
			if(maxHp<this.hp+5)
			{
				hp=maxHp;
			}
			else {
				this.hp += 5;
			}
			if(maxSp<this.sp+3)
			{
				sp=maxSp;
			}
			else {
				this.sp += 3;
			}
			
		}
		
		class Skill{
			
			String name;
			
			
			int sp;
			int damage;
			int num;
			
			public Skill()
			{
				
				this.name = "가볍게 휘두루기";
				this.sp = 0;
				this.damage = 15;
				num =1;
			}
			
			public Skill(String name,int sp,int num,int damage)
			{
				
				this.name = name;
				this.sp = sp;
				this.damage = damage;
				this.num  = num;
			
			}
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public int getSp() {
				return sp;
			}
			
			public void setSp(int sp) {
				this.sp = sp;
			}

			public int getNum() {
				return num;
			}

			public void setNum(int num) {
				this.num = num;
			}
			public int getDamage() {
				return this.damage;
			}
		
			
			
			
		}
	}



