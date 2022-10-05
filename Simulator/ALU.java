package Simulator;

import Simulator.SubPart.Gate;

public class ALU {


    // input
    // --------------------------------------------
    protected int in1;
    protected int in2;
    // --------------------------------------------


    // control
    // --------------------------------------------
    protected int aluCtrl;
    // --------------------------------------------


    // outputs
    // --------------------------------------------
    protected int zero;
    protected int result;
    // --------------------------------------------


    protected Gate gate;

    public ALU(){
        reset();

        gate = new Gate();
    }

    public void reset(){
        in1 = 0;
        in2 = 0;
        zero = 0;
        result = 0;
        aluCtrl = 0b1111;
    }

    public void setCtrl(int ctrl){
        aluCtrl = ctrl;
    }

    public void setInput(int in1, int in2){
        this.in1 = in1;
        this.in2 = in2;
    }

    public void excute(){
        gate.setControl(aluCtrl);
        gate.setInput(in1, in2);
        switch (aluCtrl) {
            case 0b0000:
                    gate.AND();
                    result = gate.getResult(); 
                break;

            case 0b0001:
                    gate.OR();
                    result = gate.getResult(); 
                break;

            case 0b0010:
                    gate.ADD();
                    result = gate.getResult(); 
                break;

            case 0b0110:
                    gate.SUBTRACT();
                    result = gate.getResult(); 
                    zero = gate.getZero();
                break;  

            case 0b0011:
                    gate.NAND();
                    result = gate.getResult(); 
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
