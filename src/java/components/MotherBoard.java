package components;

import components.Constants.DDR;

public class MotherBoard extends Part {

	// Socket Configurations
	private String cpuSocket;
	private DDR ramSocket;

	// Number of Slots for RAM, PCI/PCI-E
	private int ramSlots;
	private int pciSlots;
	private int pciESlots;

	// Compatiblilty with SLI/Crossfire
	private boolean crossfireCompatible;
	private boolean sliCompatible;

	public MotherBoard(String inModel, String inManufacturer, int inPrice,
			String inCpuSocket, DDR inRamSocket, int inRamSlots,
			int inPciSlots, int inPciESlots, boolean inSliCompatible,
			boolean inCrossfireCompatible) {
		super(inModel, inManufacturer, inPrice);

		cpuSocket = inCpuSocket;
		ramSocket = inRamSocket;

		ramSlots = inRamSlots;
		pciSlots = inPciSlots;
		pciESlots = inPciESlots;

		crossfireCompatible = inCrossfireCompatible;
		sliCompatible = inSliCompatible;

	}

	public String getCpuSocket() {
		return cpuSocket;
	}

	public DDR getRamSocket() {
		return ramSocket;
	}

	public int getRamSlots() {
		return ramSlots;
	}

	public int getPciSlots() {
		return pciSlots;
	}

	public int getPciESlots() {
		return pciESlots;
	}

	public boolean isCrossfireCompatible() {
		return crossfireCompatible;
	}

	public boolean isSliCompatible() {
		return sliCompatible;
	}
	@Override
	public String toString() {
		String result = "";
		result += "Model: " + model;
		result += "\nManufacturer: " + manufacturer;
		result += "\nPrice: " + price;
		result += "\nCPU Socket: " + cpuSocket;
		result += "\nRAM Type: " + ramSocket;
		result += "\nRAM Slots: " + ramSlots;
		result += "\nPCI Slots: " + pciSlots;
		result += "\nPCI-E Slots: " + pciESlots;
		result += "\nCrossfire: " + crossfireCompatible;
		result += "\nSLI: " + sliCompatible;

		return result;
	}
}