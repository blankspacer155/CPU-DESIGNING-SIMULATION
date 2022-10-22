import Simulator.Simulator;

import Parser.Parser;

public class ProgramTest {

    public static void main(String[] args) {

        String src = "Program_Assembly/Combination.txt";  

        new Parser(src);
        Simulator sim = new Simulator();
        sim.setMachineCode();
        sim.run();
    }
    
}
