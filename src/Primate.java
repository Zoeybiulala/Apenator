
public class Primate {
	private String name;
	private String category;
	private String bodySize;
	private boolean postOrbClo;
	private String ecto;
	private int denFormu;
	private String actTime;
	private String diet;
	private String location;
	private String color;
	private String loco;
	private String nostril;
	private boolean tail;
	private boolean denCom;
	private boolean groClaw;
	private boolean sexualDimor;
	private String spFeat; 
	
	/**
	 * @param name
	 * @param category
	 * @param bodySize
	 * @param postOrbClo
	 * @param ecto
	 * @param denFormu
	 * @param actTime
	 * @param diet
	 * @param location
	 * @param color
	 * @param nostril
	 * @param tail
	 * @param denCom
	 * @param groClaw
	 * @param spFeat
	 */
	public Primate(String[] row) {
		this.name = row[0];
		this.category = row[1];
		this.bodySize = row[2];
		if (row[3].equals("0")) {
			this.postOrbClo = false;
		} else {
			this.postOrbClo = true;
		}
		this.ecto = row[4];
		this.denFormu = Integer.parseInt(row[5]);
		this.actTime = row[6];
		this.diet = row[7];
		this.location = row[8];
		this.color = row[9];
		this.loco = row[10];
		this.nostril = row[11];
		if(row[12].equals("0")) {
			this.tail = false;
		} else {
			this.tail = true;
		}
		if(row[13].equals("0")) {
			this.denCom = false;
		} else {
			this.denCom = true;
		}
		if(row[14].equals("0")) {
			this.groClaw = false;
		} else {
			this.groClaw = true;
		}
		if(row[15].equals("0")) {
			this.sexualDimor = false;
		} else {
			this.sexualDimor = true;
		}
		this.spFeat = row[16];
		
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the bodySize
	 */
	public String getBodySize() {
		return bodySize;
	}
	/**
	 * @param bodySize the bodySize to set
	 */
	public void setBodySize(String bodySize) {
		this.bodySize = bodySize;
	}
	/**
	 * @return the postOrbClo
	 */
	public boolean isPostOrbClo() {
		return postOrbClo;
	}
	/**
	 * @param postOrbClo the postOrbClo to set
	 */
	public void setPostOrbClo(boolean postOrbClo) {
		this.postOrbClo = postOrbClo;
	}
	/**
	 * @return the ecto
	 */
	public String getEcto() {
		return ecto;
	}
	/**
	 * @param ecto the ecto to set
	 */
	public void setEcto(String ecto) {
		this.ecto = ecto;
	}
	/**
	 * @return the denFormu
	 */
	public int getDenFormu() {
		return denFormu;
	}
	/**
	 * @param denFormu the denFormu to set
	 */
	public void setDenFormu(int denFormu) {
		this.denFormu = denFormu;
	}
	/**
	 * @return the actTime
	 */
	public String getActTime() {
		return actTime;
	}
	/**
	 * @param actTime the actTime to set
	 */
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	/**
	 * @return the diet
	 */
	public String getDiet() {
		return diet;
	}
	/**
	 * @param diet the diet to set
	 */
	public void setDiet(String diet) {
		this.diet = diet;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the location
	 */

	/**
	 * @return the loco
	 */
	public String getLoco() {
		return loco;
	}
	/**
	 * @param loco the loco to set
	 */
	public void setLoco(String loco) {
		this.loco = loco;
	}
	/**
	 * @return the nostril
	 */
	public String getNostril() {
		return nostril;
	}
	/**
	 * @param nostril the nostril to set
	 */
	public void setNostril(String nostril) {
		this.nostril = nostril;
	}
	/**
	 * @return the tail
	 */
	public boolean isTail() {
		return tail;
	}
	/**
	 * @param tail the tail to set
	 */
	public void setTail(boolean tail) {
		this.tail = tail;
	}
	/**
	 * @return the denCom
	 */
	public boolean isDenCom() {
		return denCom;
	}
	/**
	 * @param denCom the denCom to set
	 */
	public void setDenCom(boolean denCom) {
		this.denCom = denCom;
	}
	/**
	 * @return the groClaw
	 */
	public boolean isGroClaw() {
		return groClaw;
	}
	/**
	 * @param groClaw the groClaw to set
	 */
	public void setGroClaw(boolean groClaw) {
		this.groClaw = groClaw;
	}
	/**
	 * @return the sexualDimor
	 */
	public boolean isSexualDimor() {
		return sexualDimor;
	}
	/**
	 * @param sexualDimor the sexualDimor to set
	 */
	public void setSexualDimor(boolean sexualDimor) {
		this.sexualDimor = sexualDimor;
	}
	/**
	 * @return the spFeat
	 */
	public String getSpFeat() {
		return spFeat;
	}
	/**
	 * @param spFeat the spFeat to set
	 */
	public void setSpFeat(String spFeat) {
		this.spFeat = spFeat;
	}
	
	
	public String toString() {
		return (name != null ? "Name: " + name + ", " : "") +"\n"
				+ (category != null ? "Category: " + category + ", " : "")+"\n"
				+ (bodySize != null ? "Body Size: " + bodySize + ", " : "") 
				+"\n"+"Post-orbital Closure: " + postOrbClo + ", "+"\n"
				+ (ecto != null ? "Ectotympanic: " + ecto + ", " : "") +"\n"
				+ "Dental Formula: " + denFormu + ","+ "\n"
				+ (actTime != null ? "Act Time: " + actTime + ", " : "") +"\n"
				+ (diet != null ? "Diet: " + diet + ", " : "")+"\n"
				+ (location != null ? "Location: " + location + ", " : "")+"\n"
				+ (color != null ? "Color: " + color + ", " : "") +"\n"
				+ (loco != null ? "Locomotion: " + loco + "," : "") +"\n"
				+ (nostril != null ? "Nostril=" + nostril + ", " : "")+"\n"
				+ "Tail=" + tail + ","+ "\n"
				+"Dental Comb=" + denCom + "\n"
				+"Grooming Claw=" + groClaw + ", "
				+"\n"
				+ (spFeat != null ? "Special Features=" + spFeat : "")+"\n";
	}
	
	
	
}
