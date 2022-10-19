package Parser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Tokenizer implements Token {
    private String src;
    private String next;
    private int pos;
    private int field_count;
    private int field_limit;

    public Tokenizer(String file_name){
        this.src = fileToString(file_name);
        pos = 0;
        field_limit = 2; //  default reserve for label and ins
        field_count = 0;
        computeNext();
    }

    private String fileToString(String file_name){
        try(BufferedReader reader = new BufferedReader(new FileReader(file_name))){
            StringBuilder content = new StringBuilder();
            String line;
    
            while ((line = reader.readLine()) != null) {
                 content.append(line);
                 content.append("\n");
           }

    return content.toString();
        }
        catch(IOException err){
            System.out.println(err);
             return "";
        }
       

    }

    private void computeNext(){
        if(pos==src.length()){  
            next = "";
            return;
        }
        while(pos<src.length() && (src.charAt(pos)==' '||(field_count==field_limit&&src.charAt(pos)!='\n'))){  //skip blank space and comment
            next = " ";
        // System.out.println("pos:"+pos+" field_count:"+field_count+" field_limit:"+field_limit);
            pos++;
            return;
        }
        if(src.charAt(pos)=='\n'){ //end line reset field limit and increase addr count
          
           // next = "\n";
           next = " ";
            field_limit=2; //set default
            field_count=0;
            pos++;
            return;
        }
        

        StringBuilder sub = new StringBuilder();
        char ch = src.charAt(pos);

        if(Character.isDigit(ch)){  //start number
            sub.append(ch);
            pos++;
            for(;pos<src.length() && Character.isDigit(src.charAt(pos));pos++){
                sub.append(src.charAt(pos));
            }
        }
        else if(ch=='-')  //negative number
        {
            sub.append(ch);
            pos++;
            for(;pos<src.length() && Character.isDigit(src.charAt(pos));pos++){
                sub.append(src.charAt(pos));
            }
        }
        else if(isCharacter(ch)||ch=='.'){ //start label or ins or .(fill)

            sub.append(ch);
            pos++;

            if(ch=='.'){  //case start with '.', then must be 'f','i','l','l'
                if(pos+3<src.length()){ //check char len
                    if((src.charAt(pos)=='f'&&src.charAt(pos+1)=='i'&&src.charAt(pos+2)=='l')&&src.charAt(pos+3)=='l'){
                    sub.append("fill");
                    pos+=4; //point at next char after last 'l'
                }
                else{
                    throw new RuntimeException("Wrong instruction : .fill");
                }
                }
                else {
                    throw new RuntimeException("Wrong instruction : .fill");
                }
            }
            else{  //label or ins
                for(;pos<src.length()
                    &&(Character.isDigit(src.charAt(pos)) || isCharacter(src.charAt(pos)));pos++){  //after first character can be a-zA-z0-9_
                sub.append(src.charAt(pos));
            }
            }
            
        }
        else{
            throw  new RuntimeException("Unknown character: >"+ch+"<");
        }

        //check syntax
        
        //next = sub.toString();
        String subStr = sub.toString();
        if(subStr.equals("noop")||subStr.equals("halt")){
            field_limit=0;
            field_count = 0;
        }
        else if(subStr.equals(".fill")){
            field_limit= 1;
            field_count=0;
        }
        else if(subStr.equals("jalr")){
            field_limit= 2;
            field_count=0;
        }
        else if(subStr.equals("add")||subStr.equals("nand")||subStr.equals("lw")||subStr.equals("sw")||subStr.equals("beq")){
            field_limit=3;
            field_count = 0;
        }
        else{ //label or number or symbolic addr
            field_count++;
        }
        next = subStr;

    }

    //check if ch is a-z,A-Z,_
    private boolean isCharacter(char ch){
        return Pattern.matches("[a-zA-z]",new StringBuilder(1).append(ch));
    }

    @Override
    public boolean hasNext() {
        if(next.equals(""))return false;
        else return true;
    }

    /**Returns next token in the input stream**/
    @Override
    public String peek(){
        while(next.equals(" ")){
            computeNext();
        }
     //   System.out.println("peek:"+next);
        return next;
    }
    /**Returns true if the next token is s **/
    @Override
    public boolean peek(String s){
        while(next.equals(" ")){
            computeNext();
        }
        return peek().equals(s);
    }
    /**Consumes the next token from input stream and return it**/
    @Override
    public String consume(){
        while(next.equals(" ")){
            computeNext();
        }
        String result = next;
   //     System.out.println("consume:"+next);
        if(pos<src.length()){
            computeNext();
            return result;
        }
        else {   //last token
            next = "";
            return result;
        }
    }
    /**Consume the next token if it is s
     * Throw syntaxError otherwise**/
    @Override
    public void consume(String s) {
        while(next.equals(" ")){
            computeNext();
        }
        if(peek(s)){
            consume();
        }
        else{
            throw new RuntimeException();
        }
    }

    
}
