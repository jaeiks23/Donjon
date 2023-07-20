package myproject;

public enum DonjonName {
LEVELUP(1),HEALING(2),POSION(3),EQUIPMENT(4),DEATH(5);
	private final  int num;
	private DonjonName(int num) {
		this.num = num;
	}
	public int getnumber() {
		return this.num;
	}

}
