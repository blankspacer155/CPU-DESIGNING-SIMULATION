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
        return value;
    }

    
}
