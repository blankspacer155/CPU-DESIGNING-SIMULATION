import Simulator.Simulator;

import java.util.Map;

import Parser.Grammars.Expression;

import java.util.LinkedHashMap;
import Parser.Parser;

public class ProgramTest {

    public static void main(String[] args) {

        String src = "Program_Assembly/Multiplication.txt";  

        int[] Memory = new int[1000];


        Parser p = new Parser(src,Memory);
        p.evaluateAll();

        
        // System.out.println(p.getNumMemory());
        //  System.out.println( p.prettyPrintAll());
        int i=0;
        for(int ins:Memory){
            System.out.println("addr["+(i++)+"] :"+ins);
        }

        Simulator sim = new Simulator();
        sim.setMachineCode(Memory, p.getNumMemory());
        sim.run();




    }
    
}
