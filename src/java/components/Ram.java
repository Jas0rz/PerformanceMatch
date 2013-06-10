package components;

import components.Constants.DDR;


public class Ram extends Part {
	// Volume of Data Storage in GB
	private int size;
	// Ram clock speed (MHz)
	private float clockSpeed;
	// Ram socket version (DDR)
	private DDR ramSocket;

	public Ram(String inModel, String inManufacturer, int inPrice,
			int size, int clockSpeed, DDR ramSocket) {
		super(inModel, inManufacturer, inPrice);

		this.size = size;
		this.clockSpeed = clockSpeed;
		this.ramSocket = ramSocket;
	}

	public int getSize() {
		return size;
	}

	public float getClockSpeed() {
		return clockSpeed;
	}

	public DDR getRamSocket() {
		return ramSocket;
	}
	@Override
	public String toString() {
		String result = "";
		result += "Model: " + model;
		result += "\nManufacturer: " + manufacturer;
		result += "\nPrice: " + price;
		result += "\nSize: " + size;
		result += "\nClock Speed: " + clockSpeed;
		result += "\nRam Type: " + ramSocket;
		return result;
	}

}
