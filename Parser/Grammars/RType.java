package Parser.Grammars;

import java.util.Map;



public class RType implements Expression {
    private Expression rA;
    private Expression rB;
    private Expression rd;
    private String ins;
    private String op_S;
    private String rA_S;
    private String rB_S;
    private String rd_S;
    private String machine_S;
    private int machine_deci;
    private String machine_hex;
    private StringBaseConverter sbc;

    public RType(Expression rA,Expression rB,Expression rd,String ins){
        this.rA = rA;
        this.rB = rB;
        this.rd = rd;
        this.ins = ins;
        sbc = StringBaseConverter.getInstance();
    }

    @Override
    public int eval( Map<String, Expression> binding) {
        int A_value = rA.eval(binding);
        int B_value = rB.eval(binding);
        int d_value = rd.eval(binding);
        
        if(ins.equals("add")){
     //       System.out.println("add rA:"+A_value+" rB:"+B_value+" rd:"+d_value);
            op_S = "000";
        }
        else { //nand
    //        System.out.println("nand rA:"+A_value+" rB:"+B_value+" rd:"+d_value);
            op_S = "001";
        }
       
        rA_S = sbc.convertToBinStr(A_value, 3, "0");
        rB_S = sbc.convertToBinStr(B_value, 3, "0");
        rd_S = sbc.convertToBinStr(d_value, 3, "0");

        machine_S = op_S+rA_S+rB_S+"0000000000000"+rd_S;

        machine_deci=sbc.convertToDeci(machine_S);
        machine_hex = sbc.convertToHex(machine_deci);

     //   System.out.println("binary string:"+machine_S+" decimal:"+machine_deci+" hex:"+machine_hex);

        return machine_deci;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        
        s.append(machine_deci+"("+machine_hex+")"+"\n");
        
    }
    
}
