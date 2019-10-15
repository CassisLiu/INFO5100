package Assignment05;

public class Pet {
	private String name;
	private String ownerName;
	private String color;
	protected int sex;
	public static final int male = 1;
	public static final int female = 2;
	public static final int spayed = 3;
	public static final int neutered = 4;
	public String getName() {
		return name;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setSex(int sexid) {
		switch(sexid) {
			case 1: sex = male;
			case 2: sex = female;
			case 3: sex = spayed;
			case 4: sex = neutered;			
		}
	}
	public String getColor() {
		return color;
	}
	public int getSex() {
		return sex;
	} 
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" owned by ").append(ownerName).append("\n")
		.append("Color: ").append(color).append("\n").append("Sex: ").append(sex);
		return sb.toString();
	}
	
}




