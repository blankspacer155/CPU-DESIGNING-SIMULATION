package Parser.Grammars;

import java.util.Map;

public class JType implements Expression {
    private Expression rA;
    private Expression rB;
    private String op_S;
    private String machine_S;
    private String rA_S;
    private String rB_S;
    private int machine_deci;
    private String machine_hex;
    private StringBaseConverter sbc;

    public JType(Expression rA,Expression rB){
        this.rA = rA;
        this.rB = rB;
        sbc = StringBaseConverter.getInstance();
    }

    @Override
    public int eval( Map<String, Expression> binding) {
        int A_value = rA.eval(binding);
        int B_value = rB.eval(binding);
        op_S = "101";
        rA_S = sbc.convertToBinStr(A_value, 3, "0");
        rB_S = sbc.convertToBinStr(B_value, 3, "0");

        machine_S = op_S+rA_S+rB_S+"0000000000000000";
        machine_deci =  sbc.convertToDeci(machine_S);
        machine_hex = sbc.convertToHex(machine_deci);
        return machine_deci;
    }


    
}
