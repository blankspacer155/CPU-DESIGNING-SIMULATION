package Parser;

public class TokenizerTest {
   
    public static void main(String[] args) {
        String testData ="          lw       0        1        five      load reg1 with 5 (uses symbolic address)\n       lw       1        2        3        load reg2 with -1 (uses numeric address)\nstart    add     1        2        1        decrement reg1\n       beq     0        1        2        goto end of program when reg1==0\n       beq     0        0        start    go back to the beginning of the loop\n       noop\ndone    halt                                  end of program\nfive      .fill      5\nneg1    .fill      -1\nstAddr  .fill      start                        will contain the address of start";
        Tokenizer tkz= new Tokenizer(testData);
        System.out.println(testData);
        System.out.println("_____________________________________________________________________________________");
        while(tkz.hasNext()){
            System.out.print(tkz.consume()+",");
        }
    }
}
