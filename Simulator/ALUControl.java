package Simulator;

public class ALUControl {
    
    // input
    // --------------------------------------------
    protected int aluop;
    // --------------------------------------------


    // outputs
    // --------------------------------------------
    protected int aluCtrl;
    // --------------------------------------------

    public ALUControl(){
        reset();
    }


    /** reset all params
     */
    public void reset(){
        aluop = 0;
        aluCtrl = 0;  
    }


    /** set input of ALUControl
     * 
     * @param aluop from Control
     */
    public void setInput(int aluop){
        this.aluop = aluop;
    }

    /** execute aluctrl for sending to ALU
     * 
     */
    public void executeCtrl() {
        switch (aluop) {
            case 0b000:                     // instruction: ADD
                aluCtrl = 0b0010;           // ALU action: add
                break;
            case 0b001:                     // instruction: NAND
                aluCtrl = 0b0011;           // ALU action: nand
                break;
            case 0b010:                     // instruction: LW
                aluCtrl = 0b0010;           // ALU action: add
                break;
            case 0b011:                     // instruction: SW
                aluCtrl = 0b0010;           // ALU action: add
                break;
            case 0b100:                     // instruction: BEQ
                aluCtrl = 0b0110;           // ALU action: subtract
                break;
            case 0b101:                     // instruction: JALR
                aluCtrl = 0b1111;           // ALU action: noop
                break;
            case 0b110:                     // instruction: HALT
                aluCtrl = 0b1111;           // ALU action: noop
                break;
            case 0b111:                     // instruction: NOOP
                aluCtrl = 0b1111;           // ALU action: noop
                break;
            default:                        // other cases (wrong opcode)
                aluCtrl = 0b1111;           // ALU action: noop
                break;
        }
    }

    /**
     * @return aluControl
     */
    public int getAluCtrl() {
        return aluCtrl;
    }

}
