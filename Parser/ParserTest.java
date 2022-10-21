package Parser;

import java.util.LinkedHashMap;
import java.util.Map;

import Parser.Grammars.Expression;

public class ParserTest {
   
    
    public static void main(String[] args) {
        String src =  "assembly_code.txt";
      int[] Memory = new int[100];
        Parser p = new Parser(src,Memory);
        p.evaluateAll();
      // System.out.println( p.prettyPrintAll());

        int i=0;
        for(int ins:Memory){
            System.out.println(ins +",");
        }
    }
}
