package Assignment05;

public class Pet {
	private String name;
	private String ownerName;
	private String color;
	protected String sex;
	public static final int male = 1;
	public static final int female = 2;
	public static final int spayed = 3;
	public static final int neutered = 4;
	public String getName() {
		return name;
	}
	public Pet(String name, String owner, String color) {
		this.name = name;
		this.ownerName = owner;
		this.color = color;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setSex(int sexid) {
		switch(sexid) {
			case male: sex = "MALE";
			case female: sex = "FEMALE";
			case spayed: sex = "SPAYED";
			case neutered: sex = "NEUTERED";			
		}
	}
	public String getColor() {
		return color;
	}
	public String getSex() {
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




