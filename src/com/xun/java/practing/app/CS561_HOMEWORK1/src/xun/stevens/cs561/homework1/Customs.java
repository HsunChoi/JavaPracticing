package xun.stevens.cs561.homework1;

public class Customs {
	private String nameString;
	private String productString;

	// Create set and get name and product methods
	public void setNameString(String name) {
		this.nameString = name;
	}

	public void setProductString(String product) {
		this.productString = product;
	}

	public String getNameString() {
		return this.nameString;
	}

	public String getProductString() {
		return this.productString;
	}
	@Override
	public boolean equals(Object arg0){
		if(this.nameString == ((Customs)arg0).nameString
				&& this.productString == ((Customs)arg0).productString){
			return true;
		}
		
		return false;
		
	}
}
