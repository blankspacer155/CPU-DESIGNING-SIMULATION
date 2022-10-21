package Parser.Grammars;

import java.util.Map;

public class IType implements Expression {
    private Expression rA;
    private Expression rB;
    private Expression offset;
    private int PC;
    private String ins;
    private String op_S;
    private String rA_S;
    private String rB_S;
    private String offset_S;
    private String machine_S;
    private int machine_deci;
    private String machine_hex;
    private StringBaseConverter sbc;


    public IType(int PC,Expression rA,Expression rB,Expression offset,String ins){
        this.PC = PC;
        this.rA = rA;
        this.rB = rB;
        this.offset  = offset;
        this.ins = ins;
        sbc = StringBaseConverter.getInstance();
    }

    @Override
    public int eval( Map<String, Expression> binding) {
        int A_value = rA.eval(binding);
        int B_value = rB.eval(binding);
        int offset_value  = offset.eval(binding);
        if(ins.equals("lw")){
            op_S = "010";

        }
        else  if(ins.equals("sw")){
            op_S = "011";
        }
        else{ //beq 
            op_S  = "100";
           
            if(offset instanceof Symbolic){  //relative addr
                offset_value =  offset_value-PC ; //use distance from current pc to symbolic address 
            }
        }

        rA_S = sbc.convertToBinStr(A_value, 3, "0");
        rB_S = sbc.convertToBinStr(B_value, 3, "0");

         //offset is between -32768 to 32767
         if(offset_value<-32768 || offset_value>32767){
            throw new RuntimeException("offsetField has more than 16 bits");
         }

        if(offset_value<0){  //negative number
             offset_S = sbc.convertToBinStr(offset_value, 16, "1"); 
        }
        else{
            offset_S = sbc.convertToBinStr(offset_value, 16, "0");
        }
       

        machine_S = op_S+rA_S+rB_S+offset_S;

        machine_deci=sbc.convertToDeci(machine_S);
        machine_hex = sbc.convertToHex(machine_deci);

        return machine_deci;
    }
   
    
}
