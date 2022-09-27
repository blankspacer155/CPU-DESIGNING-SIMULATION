package Parser.Grammars;

import java.util.Map;

public class Number implements Expression {
    private int value;
    public Number(int value){
        this.value = value;
    }

    @Override
    public int eval( Map<String, Expression> binding) {
      //  System.out.println("nuber:"+value);
        return value;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(Integer.toString(value));
        
    }
    
}
