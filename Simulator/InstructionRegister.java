package Simulator;

public class InstructionRegister {

    // outputs
    // --------------------------------------------
    protected int instr24_22;
    protected int instr21_19;
    protected int instr18_16;
    protected int instr2_0;
    // --------------------------------------------

    // halt
    // --------------------------------------------
    protected boolean isHalt;
    // --------------------------------------------

    // testing
    // --------------------------------------------
    protected String opcode;
    protected String regA;
    protected String regB;
    protected String regDst;
    // --------------------------------------------


    public InstructionRegister() {
        this.instr24_22 = 0;
        this.instr21_19 = 0;
        this.instr18_16 = 0;
        this.instr2_0 = 0;
        isHalt = false;
    }

    public void setInstr(int instr){
        instr24_22 = (instr >> 22) & 0b111;
        instr21_19 =  (instr >> 19) & 0b111;
        instr18_16 =  (instr >> 16) & 0b111;
        instr2_0 =  instr & 0b111;

        opcode = String.valueOf(Integer.toBinaryString(instr24_22));
        regA = String.valueOf(Integer.toBinaryString(instr21_19));
        regB = String.valueOf(Integer.toBinaryString(instr18_16));
        regDst = String.valueOf(Integer.toBinaryString(instr2_0));

        if(instr24_22 == 0b110) isHalt = true;
    }

    public int getInstr24_22() {
        return instr24_22;
    }

    public int getInstr21_19() {
        return instr21_19;
    }

    public int getInstr18_16() {
        return instr18_16;
    }

    public int getInstr2_0() {
        return instr2_0;
    }

    public boolean isHalt() {
        return isHalt;
    }

    


}
