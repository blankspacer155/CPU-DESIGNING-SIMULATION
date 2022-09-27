package Parser.Grammars;

import java.util.Map;

public class Fill implements Expression {
    private Expression field;
    private int value;
    public Fill(Expression field){
        this.field  =field;
    }

    @Override
    public int eval( Map<String, Expression> binding) {
         value = field.eval(binding);
      //  System.out.println("fill :"+value);
        return value;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(value+"("+"im lazy to convert"+")"+"\n");
    }
    
}
