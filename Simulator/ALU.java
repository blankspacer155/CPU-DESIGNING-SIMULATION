package Simulator;

import Simulator.SubPart.Gate;

public class ALU {
    protected int zero;
    protected int result;
    protected int aluCtrl;

    protected Gate gate;

    public ALU(){
        reset();

        gate = new Gate();
    }

    public void reset(){
        zero = 0;
        result = 0;
        aluCtrl = 0b1111;
    }

    public void setCtrl(int ctrl){
        aluCtrl = ctrl;
    }

    public void excute(int in1, int in2){
        switch (aluCtrl) {
            case 0b0000:
                   result = gate.AND(in1, in2); 
                break;

            case 0b0001:
                    result = gate.OR(in1, in2); 
                break;

            case 0b0010:
                    result = gate.ADD(in1, in2); 
                break;

            case 0b0110:
                    result = gate.SUBTRACT(in1, in2);
                    zero = result == 0 ? 1 : 0;
                break;  

            case 0b0011:
                    result = gate.NAND(in1, in2); 
                break;        
                
            case 0b1111:
                    result = 0; 
                break;                 

            default:
                    // check for invalid alu control
                break;
        }
    }

    public int getZero(){
        return zero;
    }

    public int getResult(){
        return result;
    }

}
