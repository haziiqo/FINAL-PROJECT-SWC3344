public class Citizen {
	
	private String name;
	private String ic;
	private String state;
	private int age;
	private String category;
	private String FirstDoseStatus;
	private String SecondDoseStatus;
	private String certificate;
	
	//normal constructor
	public Citizen(String name, String ic, String state, int age, String category, String FirstDoseStatus, String SecondDoseStatus, String certificate) {
		
		this.name = name;
		this.ic = ic;
		this.state = state;
		this.age = age;
		this.category = category;
		this.FirstDoseStatus = FirstDoseStatus;
		this.SecondDoseStatus = SecondDoseStatus;
		this.certificate = certificate;
		
	}
	
	//mutator
	public void setName(String name) {
		this.name = name;
	}

	public void setIc_no(String ic) {
		this.ic = ic;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setFirstDoseStatus(String FirstDoseStatus) {
		this.FirstDoseStatus = FirstDoseStatus;
	}

	public void setSecondDoseStatus(String SecondDoseStatus) {
		this.SecondDoseStatus = SecondDoseStatus;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	//accessor
	public String getName() {
		return name;
	}

	public String getIc() {
		return ic;
	}

	public String getState() {
		return state;
	}

	public int getAge() {
		return age;
	}

	public String getCategory() {
		return category;
	}

	public String getFirstDoseStatus() {
		return FirstDoseStatus;
	}

	public String getSecondDoseStatus() {
		return SecondDoseStatus;
	}

	public String getCertificate() {
		return certificate;
	}

	//string toString method
	public String toString() {
		return String.format(" %-28s %-15s \t%-16s \t%-8s \t%-15s \t%-16s \t%-16s \t%-16s %n", name, ic, state, age, category, FirstDoseStatus, SecondDoseStatus, certificate);
	}

}