package components;

import components.Constants.Architecture;

public class CPU extends Part {
	// ClockSpeed in GHz
	private float clockSpeed;

	// Number of Cores
	private int cores;

	// Socket configuration
	private String socket;

	// 32-bit OR 64-Bit Architecture
	private Architecture bitWidth;

	// Size of CPU Cache in MB
	private int cacheSize;

	public CPU(String inModel, String inManufacturer, int inPrice, int inClock,
			int inCores, String inSocket, int inCacheSize,
			Architecture inBitWidth) {

		super(inModel, inManufacturer, inPrice);
		socket = inSocket;
		cacheSize = inCacheSize;
		bitWidth = inBitWidth;
		clockSpeed = inClock;
		cores = inCores;
	}

	public int compareTo(Object what) {
		CPU other = (CPU) what;
		int difference = (int) (((clockSpeed * cores)) - (other.clockSpeed * other.cores));
		if (difference != 0) {
			return difference;
		}

		return cacheSize - other.cacheSize;
	}

	public int getCores() {
		return cores;
	}

	public float getClock() {
		return clockSpeed;
	}

	public String getSocket() {
		return socket;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public Architecture getBitWidth() {
		return bitWidth;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Model: " + model;
		result += "\nManufacturer: " + manufacturer;
		result += "\nPrice: " + price;
		result += "\nClock Speed: " + clockSpeed;
		result += "\n# of Cores: " + cores;
		result += "\nSocket: " + socket;
		result += "\nArchitecture: " + bitWidth;
		result += "\nCache Size: " + cacheSize;
		return result;
	}
}
