package components;

public class Part {
	protected String model;
	protected String manufacturer;
	protected float price;

	public Part(String inModel, String inManufacturer, int inPrice) {
		price = inPrice;
		manufacturer = inManufacturer;
		model = inModel;
	}

	public float getPrice() {
		return price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}







	

	



}
