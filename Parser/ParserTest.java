package Parser;

import java.util.LinkedHashMap;
import java.util.Map;

import Parser.Grammars.Expression;

public class ParserTest {
   
    
    public static void main(String[] args) {
        Map<String,Expression> bindings = new LinkedHashMap<>();
        String src =
        "      lw   0 1 n     $1 = 3  \n" +
        "      lw   0 2 r     $2 = 2  \n" +
        "      lw   0 4 com   save $4 = combination \n" +
        "      jalr 4 7       call com ; $7 = return address \n" +  
        "comb  beq  2 0 dog      if (r == 0 ) call c \n" + 
        "      lw   0 6 pos1   $6 = 1  \n" + 
        "      sw   5 1 stack  stored $1 in stack \n" + 
        "      add  5 6 5      increment stack pointer \n "+
        "      sw   5 2 stack  stored $2 in stack \n" +
        "      add  5 6 5      increment stack pointer \n" +
        "      beq  1 2 coal    if ( n == r ) call cc \n" + 
        "      lw   0 6 neg1   $6 = -1 \n" +
        "      add  1 6 1      $1 = $1 -1  (n=n-1) \n" +
        "      lw   0 6 conti \n" + 
        "      sw   5 6 stack \n" + 
        "      lw   0 6 pos1 \n " +
        "      add  5 6 5    \n " +
        "      beq  0 0 comb     jump to comb \n" +
        "coat  lw   0 6 neg1   \n" + 
        "      add  2 6 2      \n" +
        "      lw   0 6 pos1   \n" +
        "      add  3 6 3      \n" +
        "      add  5 6 5      \n" +
        "      lw   0 6 tree  \n" +
        "      sw   5 6 stack  \n" +
        "      lw   0 6 pos1   \n" +
        "      add  5 6 5      \n" +
        "      beq  0 0 comb    \n" + 
        "third lw   0 6 pos1   \n" +
        "      add  3 6 3      \n" +
        "coco  lw   0 6 neg1   \n" +
        "      add  5 6 5        \n" +
        "      lw   5 4 stack    load bef to $4 \n" +
        "      add  5 6 5        stack - 1 \n" + 
        "      lw   5 2 stack    \n" + 
        "      add  5 6 5        \n" + 
        "      lw   5 1 stack    \n" +
        "      jalr 4 7          \n" +
        "cat   lw   0 6 pos1     \n" + 
        "      add  3 6 3        \n" +
        "      lw   0 6 neg1     \n" + 
        "      add  5 6 5        \n" + 
        "      lw   5 4 stack    \n" +
        "com .fill comb \n" +
        "n   .fill 3 \n" +
        "r   .fill 2 \n"+
        "neg1 .fill -1 \n" + 
        "pos1 .fill  1 \n" + 
        "coal .fill coco \n" + 
        "conti  .fill coat \n"+ 
        "tree .fill third \n"+ 
        "dog  .fill cat   \n" +
        "stack .fill 0 \n"  ;       //String src= "";  
      int[] Memory = new int[100];
        Parser p = new Parser(src, bindings,Memory);
        p.evauateAll();
      // System.out.println( p.prettyPrintAll());

        int i=0;
        for(int ins:Memory){
            System.out.println(ins +",");
        }
    }
}
