package Parser.Grammars;

import java.util.Map;

public interface Expression {
    public int eval( Map<String,Expression> binding);
   
}
