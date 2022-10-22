package Parser;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import Parser.Grammars.*;
import Parser.Grammars.Number;

public class Parser {
    private Tokenizer tkz;
    private List<Expression> ASTtree;
    private Map<String,Expression> bindings;
    private static GrammarFactory grammarFactory;
    private int PC;
    private LinkedHashSet<String> instruction_set;
    private int[] Memory;

    private int numMemory;
    
    public Parser(String src){
        PC=0;//PC start at 0
        numMemory = 0;  //count how many memory is used
        String[] ins = {"noop","halt","jalr","add","nand","lw","sw","beq"};
        instruction_set = new LinkedHashSet<>(Arrays.asList(ins));  //for compare with word get form tokenizer
        this.tkz = new Tokenizer(src);
        bindings = new LinkedHashMap<>();  //pair of label and its location PC
        grammarFactory = GrammarFactory.getInstance();
        ASTtree = new LinkedList<>();  //abstract syntax tree
        this.Memory = new int[65536];
        compute();
        evaluateAll();
    }

    
    //start parsing
    private void compute() throws RuntimeException{
        parseProgram();
        if(tkz.hasNext()){
            throw new RuntimeException("Syntax Error");
            
        }

    }

    private void parseProgram() {
        while(!tkz.peek("")){   
            ASTtree.add(parseLine());  //parse 1 line and add it to ASTtree repeat until end of assembly code
        }
    }
    private Expression parseIns() {  //parse instruction
        PC++; //PC=PC+1
        Expression expr;
        String ins = tkz.consume();

         if(ins.equals("noop")||ins.equals("halt")){  
           expr = grammarFactory.getOType(ins);
        }
        else if(ins.equals("jalr")){
           expr = grammarFactory.getJType(grammarFactory.getNumber(Integer.parseInt(tkz.consume())),grammarFactory.getNumber(Integer.parseInt(tkz.consume())) );
        }
        else if(ins.equals("add")||ins.equals("nand")){
            expr = grammarFactory.getRType(grammarFactory.getNumber(Integer.parseInt(tkz.consume())),grammarFactory.getNumber(Integer.parseInt(tkz.consume())), grammarFactory.getNumber(Integer.parseInt(tkz.consume())), ins);
        }
        else if(ins.equals(".fill")){
            String field = tkz.consume();
            if(isNumber(field)){ //identify field is number or symbolic addr
                expr = grammarFactory.getFill(grammarFactory.getNumber(Integer.parseInt(field)));
            }
            else{
                expr = grammarFactory.getFill(grammarFactory.getSymbolic(field));
            }
        }
        else if(ins.equals("lw")||ins.equals("sw")||ins.equals("beq")){
            Expression rA = grammarFactory.getNumber(Integer.parseInt(tkz.consume()));
            Expression rB = grammarFactory.getNumber(Integer.parseInt(tkz.consume()));
            String Soffset = tkz.consume();
            if(isNumber(Soffset)){
                expr = grammarFactory.getIType(PC, rA, rB, grammarFactory.getNumber(Integer.parseInt(Soffset)),ins);
            }
            else{
                expr = grammarFactory.getIType(PC, rA, rB, grammarFactory.getSymbolic(Soffset),ins);
            }
        }
        else{ //label or number or symbolic addr
            System.out.println("Error:"+ins);
          throw new RuntimeException("Not instruction");
        }
        return expr;
    }

    private Expression parseLine() { // a line can start with label or instruction
       
        Expression expr;
        if(instruction_set.contains(tkz.peek())){ //start with instruction (not include .fill)
             expr =  parseIns();
        }
        else { //start with label
            String label  = tkz.consume();     
            if(bindings.containsKey(label)){//check duplicate label
                throw new RuntimeException("duplicate label");
            }
               bindings.put(label,grammarFactory.getNumber(PC)); //label contain current address
               expr =  parseIns();
        }
       return expr;
    }


    public void evaluateAll(){   //start convert ASTtree to get machine language for each address
        int i = 0;
        for(Expression expr:ASTtree){
          Memory[i++] =  expr.eval(bindings); 
          numMemory++;
        }
        //write machine code file when finish evaluate
        machineCodePrinter(Memory, numMemory);

    }

    public void machineCodePrinter(int[] memory,int numMemory){
        try{
            FileWriter writer = new FileWriter("machinecode.txt",false);
            for(int i=0;i<numMemory;i++){
                writer.write(memory[i]+"\n");
            }
            writer.close();
        }
        catch(IOException err){
            System.out.println("Error on writing machinecode.txt");
        }
    }


    public boolean isNumber(String s) throws NumberFormatException{ //check if string is number
        try{
            int parsed = Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }


    public int getNumMemory() {  // return number of memory used
        return numMemory;
    }

}
