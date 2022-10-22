package Parser.Grammars;

import java.util.Map;

public class OType implements Expression {
    private String ins;
    private String op_S;
    private String machine_S;
    private int machine_deci;
    private StringBaseConverter sbc;

    public OType(String ins){
        this.ins = ins;
        sbc = StringBaseConverter.getInstance();
    }

    @Override
    public int eval( Map<String, Expression> binding) {
        if(ins.equals("noop")){
            op_S  = "111";
        }
        else{
            op_S = "110";
        }
        machine_S = op_S+"0000000000000000000000";
        machine_deci = sbc.convertToDeci(machine_S);
        return machine_deci;
    }

}
