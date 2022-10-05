package Simulator.Test;

import Simulator.SimulationPrinter;

public class SimPrinterTest {

    public static void main(String[] args) {
        SimulationPrinter sp = new SimulationPrinter();

        int[] mc = {8454151, 9043971 , 655361 };

        sp.printMemory(mc);

        sp.printStage(0,mc, new int[7]);
    }

}
