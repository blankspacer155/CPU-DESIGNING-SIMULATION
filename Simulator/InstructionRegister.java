package Simulator;

public class InstructionRegister {

    // outputs
    // --------------------------------------------
    protected int instr24_22;
    protected int instr21_19;
    protected int instr18_16;
    protected int instr2_0;
    // --------------------------------------------

    // halt checking
    // --------------------------------------------
    protected boolean isHalt;
    // --------------------------------------------


    public InstructionRegister() {
        this.instr24_22 = 0;
        this.instr21_19 = 0;
        this.instr18_16 = 0;
        this.instr2_0 = 0;
        isHalt = false;
    }

    
    /** set instruction then divided into each parts and also check for halt
     * 
     * @param instr instruction
     */
    public void setInstr(int instr){
        instr24_22 = (instr >> 22) & 0b111;
        instr21_19 =  (instr >> 19) & 0b111;
        instr18_16 =  (instr >> 16) & 0b111;
        instr2_0 =  instr & 0b111;

        if(instr24_22 == 0b110) isHalt = true;          // check for halt instruction
    }


    /**
     * 
     * @return instruction[24-22]
     */
    public int getInstr24_22() {
        return instr24_22;
    }


    /**
     * 
     * @return instruction[21-19]
     */
    public int getInstr21_19() {
        return instr21_19;
    }


    /**
     * 
     * @return instruction[18-16]
     */
    public int getInstr18_16() {
        return instr18_16;
    }


    /**
     * 
     * @return instruction[2-0]
     */
    public int getInstr2_0() {
        return instr2_0;
    }


    public boolean isHalt() {
        return isHalt;
    }

    


}
