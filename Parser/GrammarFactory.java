package Parser;

import Parser.Grammars.*;
import Parser.Grammars.Number;

public class GrammarFactory {
    private static GrammarFactory instance;
    private GrammarFactory(){
    }

    public static GrammarFactory getInstance(){
        if(instance==null){
           instance = new GrammarFactory();
        }
        return instance;
    }

    public Expression getNumber(int value){
        return new Number(value);
    }
    public Expression getSymbolic(String label){
        return new Symbolic(label);
    }
    public Expression getFill(Expression field){
        return new Fill(field);
    }
    public Expression getRType(Expression rA,Expression rB,Expression rd,String ins){
        return new RType(rA,rB,rd,ins);
    }
    public Expression getOType(String ins){
        return new OType(ins);
    }
    public Expression getJType(Expression rA,Expression rB){
        return new JType(rA,rB);
    }
    public Expression getIType(int PC,Expression rA,Expression rB, Expression offset,String ins){
        return new IType(PC,rA,rB,offset,ins);
    }
}
