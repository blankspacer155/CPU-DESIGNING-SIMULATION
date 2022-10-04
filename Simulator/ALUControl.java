package Simulator;

public class ALUControl {
    
    protected int aluCtrl;

    public ALUControl(){
        reset();
    }

    public void reset(){
        aluCtrl = 0;  
    }

    public int getCtrl(int aluop) {
        switch (aluop) {
            case 0b000:
                return 0b0010;
            case 0b001:
                return 0b0011;
            case 0b010:
                return 0b0010;
            case 0b011:
                return 0b0010;
            case 0b100:
                return 0b0110;
            case 0b101:
                return 0b1111;
            case 0b110:
                return 0b1111;
            case 0b111:
                return 0b1111;
            default:
                return 0b1111;
        }
    }

}
