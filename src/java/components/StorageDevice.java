package components;

import components.Constants.DriveType;

public class StorageDevice extends Part {
	@Override
	public String toString() {
		return "StorageDevice [type=" + type + ", size=" + size
				+ ", readSpeed=" + readSpeed + ", writeSpeed=" + writeSpeed
				+ "]";
	}

	// HDD or SDD
	private DriveType type;

	// Data Storage in GB
	private int size;

	// read-write speeds in GB/second
	private float readSpeed;
	private float writeSpeed;

	public StorageDevice(String inModel, String inManufacturer,
			int inPrice, DriveType type, int size, float readSpeed,
			float writeSpeed) {
		super(inModel, inManufacturer, inPrice);
		this.type = type;
		this.size = size;
		this.readSpeed = readSpeed;
		this.writeSpeed = writeSpeed;
	}

	public DriveType getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	public float getReadSpeed() {
		return readSpeed;
	}

	public float getWriteSpeed() {
		return writeSpeed;
	}

}