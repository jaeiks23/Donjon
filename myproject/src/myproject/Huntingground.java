package myproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Huntingground {
	ArrayList<Monster>mlist =new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	Monster m1;
	String name = " ";
	
	public ArrayList<Monster> run1(Character character) {
		int randomnum = (int)(Math.random()*10)+1;
		int num;
		if(randomnum >6) {
			num = 1;
		}
		else {
			num =2;
		}
		
		if(character.getLevel()<2)
		{
			for(int i = 1;i<num+1;i++)
			{
			int num1 = (int)((Math.random()*6)+28);
			int num2 = (int)((Math.random()*4)+7);
			int num3 = (int)((Math.random()*5)+1);
			Randomnum(i,num1,num2,num3);
			
			}
		}
		else if(character.getLevel()<3)
		{
			for(int i = 1;i<num+1;i++)
			{
			int num1 = (int)((Math.random()*6)+45);
			int num2 = (int)((Math.random()*4)+10);
			int num3 = (int)((Math.random()*5)+1);
			Randomnum(i,num1,num2,num3);
			
			}
		}
		else if(character.getLevel()<4)
		{
			for(int i = 1;i<num+1;i++)
			{
			int num1 = (int)((Math.random()*6)+52);
			int num2 = (int)((Math.random()*5)+12);
			int num3 = (int)((Math.random()*5)+1);
			Randomnum(i,num1,num2,num3);
			
			}
		}
		else if(character.getLevel()<5)
		{
			for(int i = 1;i<num+1;i++)
			{
			int num1 = (int)((Math.random()*6)+60);
			int num2 = (int)((Math.random()*6)+15);
			int num3 = (int)((Math.random()*5)+1);
			Randomnum(i,num1,num2,num3);
			
			}
		}
		else 
		{
			for(int i = 1;i<num+1;i++)
			{
			int num1 = (int)((Math.random()*6)+70);
			int num2 = (int)((Math.random()*4)+20);
			int num3 = (int)((Math.random()*5)+1);
			Randomnum(i,num1,num2,num3);
			
			}
			
		}
		return mlist;
	}
	public  void Randomnum(int i,int num1,int num2,int num3) {
		
		
		
		
		for(MonsterName m : MonsterName.values()) {
			if(m.getNum() == num3) {
				name = m.getName();
			}
		}
		m1  = new Monster(i,name, num1, num2);
		mlist.add(m1);
		
		
	}
	
	
}
