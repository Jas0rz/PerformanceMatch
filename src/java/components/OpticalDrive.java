package components;


public class OpticalDrive extends Part {
	@Override
	public String toString() {
		return "OpticalDrive [type=" + type + ", readSpeed=" + readSpeed
				+ ", writeSpeed=" + writeSpeed + ", canWrite=" + canWrite
				+ "]";
	}

	// Drive Type
	private String type;
	// read-write speeds -- writeSpeed will equal 0 if
	// canWrite is false
	private float readSpeed;
	private float writeSpeed;
	private boolean canWrite;

	public OpticalDrive(String inModel, String inManufacturer, int inPrice,
			String type, float readSpeed, float writeSpeed, boolean canWrite) {
		super(inModel, inManufacturer, inPrice);
		this.type = type;
		this.readSpeed = readSpeed;
		this.writeSpeed = writeSpeed;
		this.canWrite = canWrite;
	}

	public String getType() {
		return type;
	}

	public float getReadSpeed() {
		return readSpeed;
	}

	public float getWriteSpeed() {
		return writeSpeed;
	}

	public boolean isCanWrite() {
		return canWrite;
	}

}
