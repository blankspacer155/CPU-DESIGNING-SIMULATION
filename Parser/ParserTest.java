package Parser;

import java.util.LinkedHashMap;
import java.util.Map;

import Parser.Grammars.Expression;

public class ParserTest {
   
    
    public static void main(String[] args) {
      String src =  "Program_Assembly/Multiplication.txt";
      Parser p = new Parser(src);
  
      // System.out.println( p.prettyPrintAll());

    }
}
