package myproject;

public enum MonsterName {
	A(1,"늙은전사"),B(2,"어린 호랑이"),C(3,"이빨빠진 악어"),D(4,"다친 늑대"),E(5,"길 고양이");
	private final String name;
	private final int num;
	private MonsterName(int num,String name) {
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	
}
