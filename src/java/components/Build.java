package components;

import java.util.ArrayList;
import java.util.Comparator;

import components.Constants.DDR;
import components.Constants.GPUInterface;

public class Build implements Comparable<Build>{

	// Component List for Build
	private MotherBoard motherBoard;
	private CPU processor;
	private ArrayList<Ram> ramSticks;
	private GPU graphicsCard;
	private StorageDevice hardDrive;
	private OpticalDrive diskDrive;

	// Free Slot Space on MotherBoard
	private int freeRamSlots;
	private int nextFreeRamSlot = 0;
	private int freePciSlots;
	private int freePciESlots;

	// flags for apparent inCompatibilities
	private boolean pciIncompatible = false;
	private boolean pciEIncompatible = false;

	public Build(MotherBoard inMoBo, CPU inCpu, GPU inGpu,
			StorageDevice inHardDrive, OpticalDrive inDiskDrive,
			Ram[] inRamSticks) throws SocketMismatchException,
			TooManyComponentsException {

		// Attach MotherBoard, with expansion Variables
		motherBoard = inMoBo;
		freeRamSlots = motherBoard.getRamSlots();
		ramSticks = new ArrayList<Ram>();

		freePciSlots = motherBoard.getPciSlots();
		freePciESlots = motherBoard.getPciESlots();

		// check for PCI/E Incompatibility
		if (freePciSlots == 0) {
			pciIncompatible = true;
		}
		if (freePciESlots == 0) {
			pciEIncompatible = true;
		}

		// Check CPU socket, attach
		String moBoCpuSocket = motherBoard.getCpuSocket();
		String cpuSocket = inCpu.getSocket();
		if (cpuSocket != moBoCpuSocket) {
			throw new SocketMismatchException();
		}
		processor = inCpu;

		// Handle having too many RAM Sticks
		if (inRamSticks.length > freeRamSlots) {
			throw new TooManyComponentsException();
		}

		// Check each Ram socket, attach each
		DDR moBoRamSocket = motherBoard.getRamSocket();
		DDR ramStickSocket;
		for (Ram thisStick : inRamSticks) {
			ramStickSocket = thisStick.getRamSocket();
			if (ramStickSocket != moBoRamSocket) {
				throw new SocketMismatchException(
						"MotherBoard does not support " + cpuSocket);
			}

			ramSticks.add(thisStick);
			freeRamSlots--;
			nextFreeRamSlot++;
		}

		// Check for GPU Slot Mismatch
		GPUInterface maleGpuSocket = inGpu.getSlotType();
		if (maleGpuSocket.equals(GPUInterface.PCI) && pciIncompatible) {
			throw new SocketMismatchException(
					"MotherBoard does not support PCI");
		}
		if (maleGpuSocket.equals(GPUInterface.PCI_E) && pciEIncompatible) {
			throw new SocketMismatchException(
					"MotherBoard does not support PCI-E");
		}

		graphicsCard = inGpu;

		// Reduce appropriate Expansion Variable
		if (graphicsCard.getSlotType().equals(GPUInterface.PCI)) {
			freePciSlots--;
		}
		if (graphicsCard.getSlotType().equals(GPUInterface.PCI_E)) {
			freePciESlots--;
		}

		hardDrive = inHardDrive;
		diskDrive = inDiskDrive;

	}

	public MotherBoard getMotherBoard() {
		return motherBoard;
	}

	public CPU getProcessor() {
		return processor;
	}

	public ArrayList<Ram> getRamSticks() {
		return ramSticks;
	}

	public GPU getGraphicsCard() {
		return graphicsCard;
	}

	public StorageDevice getHardDrive() {
		return hardDrive;
	}

	public OpticalDrive getDiskDrive() {
		return diskDrive;
	}

	public int getFreeRamSlots() {
		return freeRamSlots;
	}

	public int getPrice(){
		int total = 0;
		
		total += motherBoard.getPrice();
		total += processor.getPrice();
		total += graphicsCard.getPrice();
		total += hardDrive.getPrice();
		total += diskDrive.getPrice();
		
		for(Ram thisStick : ramSticks){
			total += thisStick.getPrice();
		}
		
		return total;
	}
 	public int getNextFreeRamSlot() {
		return nextFreeRamSlot;
	}
 	
	private int getRamSize() {
		int total = 0;
		
		for (Ram thisStick : ramSticks){
			total += thisStick.getSize();
		}
		
		return total;
	}
 	
	public int getFreePciSlots() {
		return freePciSlots;
	}

	public int getFreePciESlots() {
		return freePciESlots;
	}

	public boolean isPciIncompatible() {
		return pciIncompatible;
	}

	public boolean isPciEIncompatible() {
		return pciEIncompatible;
	}

	public String toString() {
		String result = "";
		
		//Brief Overview
		result += "BUILD OVERVIEW: \n";
		result += "\nTOTAL PRICE: " + getPrice();
		result += "\nCPU CLOCK: " + getProcessor().getClock();
		result += "\nRAM SIZE: " + getRamSize() + "GB";
		result += "\nGPU MODEL: " + getGraphicsCard().getModel();
		
		//Component Specs:
		result += "\n\nMotherBoard: \n" + motherBoard;
		result += "\n\nCPU: \n" + processor;
		result += "\n\nGPU: \n" + graphicsCard;
		result += "\n\nRAM: \n";

		for (Ram thisStick : ramSticks) {
			result += thisStick.toString() + "\n\n";
		}

		result += "\nData Storage: \n" + hardDrive;
		result += "\nDisk Drive \n" + diskDrive;

		return result;
	}
	

	public static final Comparator<Build> byCPUClock() {
		return new Comparator<Build>(){
			public int compare(Build rig1, Build rig2){
				return rig1.getProcessor().compareTo(rig2.getProcessor());
			}
		};
	}
	
	public static final Comparator<Build> byGPUSpecs(){
		return new Comparator<Build>(){
			public int compare(Build rig1, Build rig2){
				/**
				 * TO DO FINISH COMPARETO FOR GPU
				 */
				return rig1.getGraphicsCard().compareTo(rig2.getGraphicsCard());
			}
		};
	}
 
	class SocketMismatchException extends Exception {
		private static final long serialVersionUID = 1L;

		public SocketMismatchException() {
		}

		public SocketMismatchException(String message) {
			super(message);
		}
	}

	class TooManyComponentsException extends Exception {
		private static final long serialVersionUID = 1L;

		public TooManyComponentsException() {
		}

		public TooManyComponentsException(String message) {
			super(message);
		}
	}

	@Override
	public int compareTo(Build arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
