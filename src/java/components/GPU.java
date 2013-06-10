package components;

import components.Constants.DDR;
import components.Constants.GPUInterface;

public class GPU extends Part {
	
	// Clock speed of GPU
	private float clockSpeed;

	// Physical volume of GPU
	private int partVolume;

	// Memory Size (GB), Speed (GB/sec), and Version (DDR)
	private int gRamSize;
	private float gRamSpeed;
	private DDR gRamSlot;

	// PCI/PCIE interface
	private GPUInterface slotType;

	// Crossfire/SLI compatibility
	private boolean crossfireCompatible;
	private boolean sliCompatible;

	public GPU(float clockSpeed, int partVolume, int gRamSize,
			float gRamSpeed, DDR gRamSlot, GPUInterface slotType,
			boolean crossfireCompatible, boolean sliCompatible,
			String inModel, String inManufacturer, int inPrice) {

		super(inModel, inManufacturer, inPrice);

		this.clockSpeed = clockSpeed;
		this.partVolume = partVolume;
		this.gRamSize = gRamSize;
		this.gRamSpeed = gRamSpeed;
		this.gRamSlot = gRamSlot;
		this.slotType = slotType;
		this.crossfireCompatible = crossfireCompatible;
		this.sliCompatible = sliCompatible;
	}
	
	public int compareTo(Object what){
		GPU other = (GPU) what;
		int difference = (int) (clockSpeed - other.clockSpeed);
		if(difference != 0){
			return difference;
		}
		
		difference = (int) (gRamSpeed - other.gRamSpeed);
		if(difference != 0){
			return difference;
		}
		
		difference = gRamSize - other.gRamSize;
		return difference;
		}

	public float getClockSpeed() {
		return clockSpeed;
	}

	public int getPartVolume() {
		return partVolume;
	}

	public int getgRamSize() {
		return gRamSize;
	}

	public float getgRamSpeed() {
		return gRamSpeed;
	}

	public DDR getgRamSlot() {
		return gRamSlot;
	}

	public GPUInterface getSlotType() {
		return slotType;
	}

	public boolean isCrossfireCompatible() {
		return crossfireCompatible;
	}

	public boolean isSliCompatible() {
		return sliCompatible;
	}

	public String toString(){
		String result = "";
		result += "Model: " + model;
		result += "\nManufacturer: " + manufacturer;
		result += "\nPrice: " + price;
		result += "\nClock Speed: " + clockSpeed;
		result += "\nGRAM Size: " + gRamSize;
		result += "\nGRAM Speed: " + gRamSpeed;
		result += "\nGRAM Type: " + gRamSlot;
		
		return result;
	}
}