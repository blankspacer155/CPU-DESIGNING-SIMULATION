package Simulator.Test;

import Simulator.Simulator;

public class SimulatorTest {
    

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        int[] machcode = {
            8454151,
            9043971,
            655361,
            16842754,
            16842750,
            29360128,
            25165824,
            5,
            -1,
            2
        };
        sim.setMachineCode(machcode);
        sim.run();

    }
}
