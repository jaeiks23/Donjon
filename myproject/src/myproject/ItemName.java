package myproject;

public enum ItemName {
	Sword("Human"),Bow("Elf"),Club("oak");
		
		private final String name;
		
		private ItemName(String name) {
			this.name = name;
			
		}
		public String getName() {
			return name;
		}
	}

