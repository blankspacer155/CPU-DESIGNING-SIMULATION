package Simulator;

public class InstructionRegister {
    protected int instr24_22;
    protected int instr21_19;
    protected int instr18_16;
    protected int instr2_0;



    public InstructionRegister() {
        this.instr24_22 = 0;
        this.instr21_19 = 0;
        this.instr18_16 = 0;
        this.instr2_0 = 0;

    }

    public void setInstr(int instr){
        instr24_22 = (instr >> 21) & 0b111;
        instr21_19 =  (instr >> 18) & 0b111;
        instr18_16 =  (instr >> 15) & 0b111;
        instr2_0 =  instr & 0b111;
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

    


}
