package myproject;



public class Item {
	
	String name;
	int number;
	
	
	public Item(String name) {
		
		this.name =name;
		
		
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void getItem() {
		System.out.println(name +"을 획득하셨습니다");
	
	}
	public void UseItem() {
		
		System.out.println(name +"을 사용하셨습니다");
		
	}

	public void Iteminfo()
	{
		System.out.println(getName());
	}
	
}
