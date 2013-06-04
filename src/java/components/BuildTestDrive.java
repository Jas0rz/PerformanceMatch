package components;

import java.util.ArrayList;


import components.Constants.DDR;
import components.Constants.DriveType;
import components.Constants.GPUInterface;
import components.Build.SocketMismatchException;
import components.Build.TooManyComponentsException;

public class BuildTestDrive {


	public static void main(String[] args) throws SocketMismatchException, TooManyComponentsException {
	//MoBo1 = no edge -- MoBo2 = Better CPU Sock -- MoBo3 = Better RAM Type
	MotherBoard myMoBo1 = new MotherBoard("MODEL12345", "JESUS & CO", 666, "DICKS", DDR.DDR2, 4, 0, 2, false, false);
	MotherBoard myMoBo2 = new MotherBoard("MODEL12345", "JESUS & CO", 666, "COCKS", DDR.DDR2, 4, 0, 2, false, false);
	MotherBoard myMoBo3 = new MotherBoard("MODEL3", "LAISDH", 350, "DICKS", DDR.DDR3, 4, 0, 2, false, false);
	
	//CPU2 generically better
	CPU myCPU1 = new CPU("i5", "Intel", 100, 15, 4, "DICKS", 999, Constants.Architecture.BIT32);
	CPU myCPU2 = new CPU("i7", "Intel", 200, 25, 4, "COCKS", 9999, Constants.Architecture.BIT64);
	
	//GPU 2 Better clock speed
	GPU myGPU1 = new GPU(2.8f , 600, 4, 600, DDR.GDDR5, GPUInterface.PCI_E, false, false, "GPUv4.0", "Nvidia", 999);
	GPU myGPU2 = new GPU(3.8f , 600, 4, 600, DDR.GDDR5, GPUInterface.PCI_E, false, false, "GPUv4.0", "Nvidia", 999);

	
	//Prepare Ram -- Ram2 Generically Better
	Ram[] myRams1 = new Ram[myMoBo1.getRamSlots()];
	Ram[] myRams2 = new Ram[myMoBo1.getRamSlots()];
	Ram ram1 = new Ram("RAM 500", "WHO CARES", 800, 123, 234, DDR.DDR2);
	Ram ram2 = new Ram("RAM 700", "STILL DONT CARE", 900, 321, 321, DDR.DDR3);
	myRams1[0] = ram1;
	myRams1[1] = ram1;
	myRams1[2] = ram1;
	myRams1[3] = ram1;
	myRams2[0] = ram2;
	myRams2[1] = ram2;
	myRams2[2] = ram2;
	myRams2[3] = ram2;
	
	OpticalDrive myDiskDrive = new OpticalDrive("DiscSMASH", "JASON", 123, "RECORDS", 123, 321, true);
	StorageDevice mySSD = new StorageDevice("NOONE CARES", "USED TO CARE", 999, DriveType.SSD, 200, 123, 321);
	
	Build gpuBuild = new Build(myMoBo1, myCPU1, myGPU2, mySSD, myDiskDrive, myRams1);
	Build cpuBuild = new Build(myMoBo2, myCPU2, myGPU1, mySSD, myDiskDrive, myRams1);
	Build ramBuild = new Build(myMoBo3, myCPU1, myGPU1, mySSD, myDiskDrive, myRams2);
	
	ArrayList<Build> BuildList = new ArrayList<Build>();
	
	BuildList.add(gpuBuild);
	BuildList.add(cpuBuild);
	BuildList.add(ramBuild);
	
	System.out.println(gpuBuild);
	
	}

}
