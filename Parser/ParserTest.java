package Parser;

import java.util.LinkedHashMap;
import java.util.Map;

import Parser.Grammars.Expression;

public class ParserTest {
   
    
    public static void main(String[] args) {
        Map<String,Expression> bindings = new LinkedHashMap<>();
        String src ="          lw       0        1        five      load reg1 with 5 (uses symbolic address)\n       lw       1        2        3        load reg2 with -1 (uses numeric address)\nstart    add     1        2        1        decrement reg1\n       beq     0        1        2        goto end of program when reg1==0\n       beq     0        0        start    go back to the beginning of the loop\n       noop\ndone    halt                                  end of program\nfive      .fill      5\nneg1    .fill      -1\nstAddr  .fill      start                        will contain the address of start";
      //String src= "";  
      int[] Memory = new int[10];
        Parser p = new Parser(src, bindings,Memory);
        p.evauateAll();
      // System.out.println( p.prettyPrintAll());

        int i=0;
        for(int ins:Memory){
            System.out.println("addr["+(i++)+"] :"+ins);
        }
    }
}
