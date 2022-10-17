import Simulator.Simulator;

import java.util.Map;

import Parser.Grammars.Expression;

import java.util.LinkedHashMap;
import Parser.Parser;

public class ProgramTest {

    public static void main(String[] args) {
        Map<String,Expression> bindings = new LinkedHashMap<>();
        
        
        
        
        
        String src=
        "      lw   0 3 one iterator = 1\n" +
        "      lw   0 2 sign $2 = 1073741824  \n" + 
        "      lw   0 6 mcand   $6 = mcand  \n" + 
        "      lw   0 7 mplier $7 = mplier  \n" +
        "mul   nand 7  3  5 (plier nand iterator) = temp \n" + 
        "      nand 5 5  5  (temp nand temp) = temp \n" + 
        "      beq  0 5 cat  if(temp == zero) go to L1 \n" + 
        "      add  1 6 1  result = result + cand\n" + 
        "cat     add  3 3  3  iterator = iterator + iterator \n"+
        "      add  6 6  6    cand = cand + cand  \n" + 
        "      beq  2 3  done   if(iterator == sign) go to exit \n"+
        "      beq  0 0  mul   jump to multiplication \n" + 
        "      noop          \n" +
        "done  halt end of program  \n"+
        "one .fill 1 \n"+
        "mcand  .fill 32766 \n" + 
        "mplier .fill 10383\n" +  
        "sign .fill 1073741824 " ;

        int[] Memory = new int[500];
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
