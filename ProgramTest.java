import Simulator.Simulator;

import Parser.Parser;

public class ProgramTest {

    public static void main(String[] args) {

        String src = "Program_Assembly/Combination.txt";  

        Parser p = new Parser(src);
        p.evaluateAll();

        
        // // System.out.println(p.getNumMemory());
        // //  System.out.println( p.prettyPrintAll());
        
        // int i=0;
        // for(int ins:Memory){
        //     System.out.println("addr["+(i++)+"] :"+ins);
        // }

        Simulator sim = new Simulator();
        sim.setMachineCode();
        sim.run();

    }
    
}
