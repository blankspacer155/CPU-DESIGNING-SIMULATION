package Simulator.Test;

import Simulator.Simulator;

public class SimulatorTest {
    

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.setMachineCode();
        sim.run();
    }
}
