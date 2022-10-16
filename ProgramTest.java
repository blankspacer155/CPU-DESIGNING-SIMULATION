import Simulator.Simulator;

import java.util.Map;

import Parser.Grammars.Expression;

import java.util.LinkedHashMap;
import Parser.Parser;

public class ProgramTest {

    public static void main(String[] args) {
        Map<String,Expression> bindings = new LinkedHashMap<>();
        
        
        
        
        
        String src=
        "       lw 0 6 base \n" +
        "       lw 0 7 exponent \n" +
        "       lw 0 2 sign \n" +
        "       lw 0 0 neg1 \n" +
        "       lw 0 4 one  \n" +
        "done   halt  \n"+


        "one1 .fill 1 \n"+
        "base .fill 4 \n"+
        "exponent .fill 3 \n"+
        "neg1 .fill -1 \n" +
        "sign .fill 1073741824 \n" ; 

        int[] Memory = new int[100];
        int numSrcCode = src.split("\n").length;


        Parser p = new Parser(src, bindings,Memory);
        p.evauateAll();

         System.out.println( p.prettyPrintAll());

       // int i=0;
        // for(int ins:Memory){
        //     System.out.println("addr["+(i++)+"] :"+ins);
        //}

        Simulator sim = new Simulator();
        sim.setMachineCode(Memory, numSrcCode);
        sim.run();




    }
    
}
