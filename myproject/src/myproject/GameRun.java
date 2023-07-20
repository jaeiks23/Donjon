package myproject;


import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;

import java.util.InputMismatchException;


import java.util.Scanner;





public class GameRun {
	static Scanner sc = new Scanner(System.in);
	static File file = new File("D:/myproject/myproject/src/myproject/Saving/Savebone.txt");
	static int flag = 1;
	static Character character;
	
	
	static Monster boss = new Boss();
	static ArrayList<Monster>mlist =new ArrayList<>();
	Monster m1;
	static int num1 = 1;
	static boolean moving = true;

	static int count =12;
	
	public static void main(String[] args) {
		int count = 12;
		boolean  start= true;
		int flag;
		int num=0;
		ArrayList<Character>charlist = new ArrayList<>();
		ArrayList<Integer>counlist = new ArrayList<>();
		outerloop:
			while(start)
			{
				print1();
				
				System.out.println("저장한 정보를 불러오시겠습까?(맞으면 y, 아니면 아무키나 눌러주세요)");
				String yew = sc.next().toUpperCase();
				if(yew.equals("Y")) {
					System.out.println("플레이를 하실려면 1번,데이터 정보를 지우시려면 2번을 눌러주세요");
					Load(charlist,counlist);
					for(int i=0;i<charlist.size();i++)
					{
						System.out.println((i+1)+"."+charlist.get(i).getName()+" Level: "+charlist.get(i).getLevel());
					}
					int num0 = exceptionsolution();
					if(num0 == 1)
					{
						
						for(int i=0;i<charlist.size();i++)
						{
							System.out.println((i+1)+"."+charlist.get(i).getName()+" Level: "+charlist.get(i).getLevel());
						}
						System.out.println("몇 번째 정보를 불러오시겠습니까?");
						int number4 = exceptionsolution();
						if((number4)>charlist.size()) {
							System.out.println("잘못 누르신거 같습니다");
							continue;
						}
						character = charlist.get((number4-1)); 
						count = counlist.get((number4-1));
						mlist.clear();
						
					}
					else if(num0 ==2) {
					Remove(charlist, counlist);
						break outerloop;
					}
					else {
						System.out.println("잘못입력하셨습니다");
						break outerloop;
					}
					
				}
				else {
					
					do{
						flag = 1;
						try{
							
							System.out.println("생성하실 캐릭터를 입력해주세요");
							System.out.println("1.Oak  2.elf  3.human");
							num = sc.nextInt();
							
						}
						catch(InputMismatchException e){
							flag=0;
							sc.nextLine();
							System.out.println("정상적인 숫자를 입력하세요");
						}
						
					}while(flag==0);
					if(num ==1)
					{
						character = new Oak();
					}
					else if(num ==2) {
						character = new Elf();
					}
					else if(num ==3) {
						character = new Human();
					}
				}
					charlist.add(character);
					counlist.add(count);
					System.out.println("당신은 "+ character.getName()+"를 선택하셨습니다");
					character.setAlive();
					for(int i = 0; i<count;i++,count--)
					{	
						System.out.println("보스까지 남은 라운드: " +count);
						if(character.getalive()==true)
						{
							System.out.println("들어가시겠습니까?(아무키나 입력해 주십시요)");
							String yesorno = sc.next();
							int random = (int)(Math.random()*10)+1;
							if(random>9) {
								Donjon donjon = new Donjon();
								donjon.run3(character);
								if(character.getalive()!=true)
								{
									break;
								}
								
								if(Save(charlist,counlist)) {
									start=false;
									
									break;
								}
							}
							else if(random>7) {
								HealingCenter center = new HealingCenter();
								center.run(character);
								if(Save(charlist,counlist)) {
									start=false;
									
									break;
								}
							}
							else {
								Huntingground hun = new Huntingground();
								mlist = hun.run1(character);
								System.out.println("몬스터가 등장했다!");
								
								printtt(mlist,character);
								if(character.getalive()!=true){
									break;
								}
								
								
								System.out.println("전투에서 승리하셨습니다");
								if(Save(charlist,counlist)) {
									start=false;
								
									break outerloop;
								}
							}
							moving = true;
							System.out.println();
						}
						else {
							System.out.println("당신은 죽었습니다");
							
							System.out.println("종료하시려면 아무키나  눌러주세요");
							
							String yesorno = sc.next().toUpperCase();
							if(yesorno.equals("Y")) {
								character.setAlive();
							
								break;
							}
							start = false;
							break outerloop;
						}
					}
					
					if(character.getalive()!=true){
						System.out.println("당신은 죽었습니다");
						System.out.println("계속 하시겠습니까? 하고싶으시면 Y , 싫으시면 아무키나 눌러주세요");
						
						String yesorno = sc.next().toUpperCase();
						if(yesorno.equals("Y")) {
							character.setAlive();
							break;
						}
						else {
							start=false;
							break;
							
						}
					}
					System.out.println("보스 등장!");
					mlist.add(boss);
					printtt(mlist,character);
					System.out.println("전투 완료");
					
					if(character.getalive()==true)
					{
						System.out.println("Clear");
						start = false;
						break;
					}
					
					if(character.getalive()!=true){
						System.out.println("당신은 죽었습니다");
						System.out.println("계속 하시겠습니까? 하고싶으시면 Y , 싫으시면 아무키나 눌러주세요");
						
						String yesorno = sc.next().toUpperCase();
						if(yesorno.equals("Y")) {
							character.setAlive();
							continue;
						}
						else {
							start=false;
							break;
							
						}
					}
					
					
				}
				
				
				
				
				
				
				
			}

		

	
	
	
	
	

	public static void print1() {
		System.out.println("===================================");
		System.out.println("===================================");
		System.out.println();
		System.out.println("               Donjon              ");
		System.out.println();
		System.out.println("===================================");	
		System.out.println("===================================");
	}
	public static void ShowMonsterInfo(Monster mon) {
		mon.ShowMonster();
	}
	public static void printtt(ArrayList<Monster> mli,Character charater) {
		
		out:
		while(moving)
		{
			if(mli.isEmpty()) {
				break out;
				}
	
			System.out.println("                 ᴇɴᴇᴍʏ");
			showMonsterinfo(mli);
			System.out.println();
			System.out.println("                  상태창");
			charater.CharacterInfo();
			System.out.println();
			System.out.println("▷▷▷▷▷▷▷▷▷▷▷▷▷Select Action◁◁◁◁◁◁◁◁◁◁◁◁◁");
			System.out.println("1.기술을 선택한다. 2.아이템을 사용한다 3.능력치를 본다.");
			int num2 = exceptionsolution();
			switch(num2) {
			case 1:
				charater.ShowanddecreaseSp();
				int num3 =	exceptionsolution();
				if(num2>=5) {
					System.out.println("없는 번호입니다.");
					break;
				}
				int damage = charater.selectSkill(num3);
				
				if(damage == 0)
					break;
				System.out.println("공격할 대상을 선택하세요");
				System.out.println();
				System.out.println("           Select                ");
				showMonsterinfo(mli);
				
				int num4 = exceptionsolution();
				if(mli.size()>=num4)
				{
					for(Monster m : mli)
					{
						
						if(m.getNumber()==num4)
						{
							m.decreaseHp(damage);
						}
					}
					
				}
				else {
					System.out.println("대상을 찾을 수 없습니다.");
					
				}
				
				if(checkMonster(mli,charater)) {
					if(mli.size() == 0) {
						break;
						
					}
				}
				
				
				for(Monster m:mli) {
					if(m.getName().equals("흑룡"))
					{
						
						if(m.getHp()<40)
						{
							m.Skill(charater);
						}
						else {
							if(charater.CheckEscape())
							{
								charater.heating(0);
							}
							else {
								charater.heating(m.getDamage());
								System.out.println(m.getName()+"가 "+ charater.getName()+"에게 "+ m.getDamage()+"을 입혔습니다" );
								
							}
							
						}
						CheckHp(charater);
						
					}
					else {
						if(charater.CheckEscape())
						{
							charater.heating(0);
						}
						else {
							charater.heating(m.getDamage());
							System.out.println(m.getName()+"가 "+ charater.getName()+"에게 "+ m.getDamage()+" 피해를 입혔습니다" );
							CheckHp(charater);
						}
						
					}
				}
				System.out.println();
				
				if(charater.getalive()==false)
				{
					moving=false;
					break;
				}
				
				
				continue;
				
			case 2:
				charater.ShowItemList();
				System.out.println("사용할 아이템을 입력해 주십시요");
				
				int number = exceptionsolution();
				if(charater.itemlist.size() < number)
				{
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
				charater.UseHpposion(number);
				
				continue;
				
			case 3:charater.CharacterAllInfo();
			continue;
			
			default: System.out.println("잘못입력하셨습니다"
					+ ".");
			continue;
			}
			
			
		}
	}

	public static boolean checkMonster(ArrayList<Monster> mli,Character charater) {	
		for(Monster m : mli)
		{	
			if(m.getHp()<=0) {
				mli.remove(m);
				getItem(charater);
				charater.IncreaseCharger();
				charater.FightingEnd();
				checkMonster1(mli);
				return true;
			}
		}
		return false;
	}
	public static void checkMonster1(ArrayList<Monster> mli) {
		
		for(Monster m : mli)
		{	
			m.setNumber(1);
		}
		
	}
	public static void showMonsterinfo(ArrayList<Monster> mli) {
		for(Monster m : mli)
		{
			m.ShowMonster();
			
		}
	}
	public static void CharacterAlive(Character charater) {
		charater.CharacterAlive();
	}
	public static void getItem(Character charater) {
		int random = (int)(Math.random()*9)+1;
		if(random>8)
		{
			System.out.println("hp 포션 획득!");
			charater.itemlist.add(new Item("hp 포션"));
		}
		
		
	}
	public static void CheckHp(Character charater) {
		
		charater.CharacterAlive();
		
		
	}
	public static void Brass(Monster mon,Character charater) {
		
		
		if(mon.getHp()<40) {
			
			System.out.println(mon.name+ "이 브레스를 쏩니다");
			charater.setHp();
			num1=0;
		}
	}
	public static int exceptionsolution() {
		int num =1;
		do{
            flag = 1;
            try{
                
				num = sc.nextInt();
               
                }
            catch(InputMismatchException e){
                flag=0;
                sc.nextLine();
                 System.out.println("정상적인 숫자를 입력하세요");
                }
             
        }while(flag==0);
		  return num;
	}
	public static boolean Save(ArrayList<Character> charlist,ArrayList<Integer>counlist) {
		
		System.out.println("저장하시겠습니까?(하고싶으시면 Y 아니면 아무키나 눌러주세요)");
		String beingSave = sc.next().toUpperCase();
		if(beingSave.equals("Y"))
		{
			
		
		try(
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				){
			for(int i =0;i<charlist.size();i++) {
				
				osw.write(charlist.get(i).getName());
				osw.write(",");
				
				
				osw.write(Integer.toString(charlist.get(i).getMaxHp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getMaxSp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getHp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getSp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getDamage()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getLevel()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getCharge()));
				
				
				
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getEscape()));
				osw.write(",");
				for(Item it: charlist.get(i).getItemlist())
				{
					osw.write(it.getName());
					osw.write("/");
				}
				osw.write(",");
				osw.write(Integer.toString(counlist.get(i)));
				osw.write("\n");
			}
			
			
			
			System.out.println("저장되었습니다");
			
			return true;
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("파일이 안써짐");
		}
		}
		
			return false;
		
	}
	public static void Save2(ArrayList<Character> charlist,ArrayList<Integer>counlist) {
		try(
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				){
			for(int i =0;i<charlist.size();i++) {
				
				osw.write(charlist.get(i).getName());
				osw.write(",");
				
				
				osw.write(Integer.toString(charlist.get(i).getMaxHp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getMaxSp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getHp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getSp()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getDamage()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getLevel()));
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getCharge()));
				
				
				
				osw.write(",");
				osw.write(Integer.toString(charlist.get(i).getEscape()));
				osw.write(",");
				for(Item it: charlist.get(i).getItemlist())
				{
					osw.write(it.getName());
					osw.write("/");
				}
				osw.write(",");
				osw.write(Integer.toString(counlist.get(i)));
				osw.write("\n");
			}
			
			
			
		
			
			
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("파일이 안써짐");
		}
	}
	public static boolean Remove(ArrayList<Character> charlist,ArrayList<Integer> counlist)
	{
		System.out.println("지우실 데이터의 번호를 입력하여 주세요");
		int num = exceptionsolution();
		if(num > charlist.size())
		{
			System.out.println("데이터가 없습니다.");
			return false;
		}
		charlist.remove(num);
		Save2(charlist, counlist);
		System.out.println("성공적으로 지웠습니다");
		return true;
		
	}
	public static void Load(ArrayList<Character> charlist,ArrayList<Integer> counlist) {
		
		if(!file.exists())
		{
			System.out.println("존재하지않습니다");
			return;
		}
		
		
		
			
			try(
					Reader reader = new FileReader(file);
				
					BufferedReader br = new BufferedReader(reader);
			
					){
				
					String data = "";
					while((data=br.readLine())!= null)
					{
						String[] data2 = data.split(",");
						String name = data2[0].trim();
						int maxHp = Integer.parseInt(data2[1].trim());
						int maxSp = Integer.parseInt(data2[2].trim());
						int hp = Integer.parseInt(data2[3].trim());
						int sp = Integer.parseInt(data2[4].trim());
						int damage = Integer.parseInt(data2[5].trim());
						int level = Integer.parseInt(data2[6].trim());
						int charge = Integer.parseInt(data2[7].trim());
						int escape = Integer.parseInt(data2[8].trim());
						int count2 = Integer.parseInt(data2[10].trim());
						String iteml = data2[9];
						
						if(name.equals("오크"))
						{
							character = new Oak(name,maxHp,maxSp,hp,sp,damage,level,charge,escape);
						}
						else if(name.equals("엘프"))
						{
							character = new Elf(name,maxHp,maxSp,hp,sp,damage,level,charge,escape);
						}
						else {
							character = new Human(name,maxHp,maxSp,hp,sp,damage,level,charge,escape);
						}
						
						String[] iteml2 = iteml.split("/");
						character.itemlist.clear();
						
						for(String s : iteml2) {
							Item item = new Item(s);
							character.itemlist.add(item);
						}
						charlist.add(character);
						counlist.add(count2);
					}
				
				
				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				System.out.println("파일이 안써짐");
			}
		
		
		
	}
	
}