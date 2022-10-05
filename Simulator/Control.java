package Simulator;

public class Control {

    // input
    // --------------------------------------------
    protected int opcode;
    // --------------------------------------------


    // outputs
    // --------------------------------------------
    protected int MemWrite;
    protected int MemRead;
    protected int MemToReg;
    protected int RegWr;
    protected int RegDst;
    protected int ALUsrc;
    protected int ALUop;
    protected int Branch;
    protected int Jump;
    // --------------------------------------------


    public Control() {
        opcode = 0;
        reset();
    }

    public void reset(){
        
        MemWrite = 0;
        MemRead = 0;
        MemToReg = 0;
        RegWr = 0;
        RegDst = 0;
        ALUsrc = 0;
        ALUop = 0;
        Branch = 0;
        Jump = 0;
    }

    public void setopcode(int opcd){
        this.opcode = opcd;
    }

    public void excuteControl(){  
        reset();
        ALUop = opcode;
        switch (opcode) {
            case 0b000:         // AND
                RegWr = 1;
                RegDst = 1;
                break;

            case 0b001:         // NAND
                RegWr = 1;
                RegDst = 1;    

                break;
            case 0b010:         // LW
                MemRead = 1;
                MemToReg = 1;    
                ALUsrc = 1;
                RegWr = 1;  

                break;
            case 0b011:         // SW
                MemWrite = 1;
                ALUsrc = 1;

                break;
            case 0b100:         // BEQ
                Branch = 1;    

                break;
            case 0b101:         // JALR
                Jump = 1;
                RegWr = 1;    

                break;
            case 0b110:         // HALT
                
                break;
            case 0b111:         // NOOP
                
                break;
            default:
                break;
        }
    }

    public int getMemWrite() {
        return MemWrite;
    }

    public int getMemRead() {
        return MemRead;
    }

    public int getMemToReg() {
        return MemToReg;
    }

    public int getRegWr() {
        return RegWr;
    }

    public int getRegDst() {
        return RegDst;
    }

    public int getALUsrc() {
        return ALUsrc;
    }

    public int getALUop() {
        return ALUop;
    }

    public int getBranch() {
        return Branch;
    }

    public int getJump() {
        return Jump;
    }
    
}
