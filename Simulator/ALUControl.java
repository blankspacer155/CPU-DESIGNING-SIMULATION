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

    public void reset(){
        aluCtrl = 0;  
    }

    public void setInput(int aluop){
        this.aluop = aluop;
    }

    public void excuteCtrl() {
        switch (aluop) {
            case 0b000:
                aluCtrl = 0b0010;
                break;
            case 0b001:
                aluCtrl = 0b0011;
                break;
            case 0b010:
                aluCtrl = 0b0010;
                break;
            case 0b011:
                aluCtrl = 0b0010;
                break;
            case 0b100:
                aluCtrl = 0b0110;
                break;
            case 0b101:
                aluCtrl = 0b1111;
                break;
            case 0b110:
                aluCtrl = 0b1111;
                break;
            case 0b111:
                aluCtrl = 0b1111;
                break;
            default:
                aluCtrl = 0b1111;
                break;
        }
    }

    
    public int getAluCtrl() {
        return aluCtrl;
    }

}
