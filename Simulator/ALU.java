package Simulator;

import Simulator.SubPart.Gate;


public class ALU {

    // inputs
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


    // gate (use for executing)
    // --------------------------------------------
    protected Gate gate;
    // --------------------------------------------

    /**
     * constructor
     */
    public ALU(){
        reset();
        gate = new Gate();
    }


    /** reset all params, constructor call this
     * 
     */
    public void reset(){
        in1 = 0;
        in2 = 0;
        zero = 0;
        result = 0;
        aluCtrl = 0b1111;
    }


    /** set control for ALU executing
     * 
     *  @param ctrl control that determine which operation
     * 
     */
    public void setCtrl(int ctrl){
        aluCtrl = ctrl;
    }


    /** set inputs of ALU
     * 
     *  @param in1 first input from RegisterA
     * 
     *  @param in2 second input from RegisterB or ImmGen
     */
    public void setInput(int in1, int in2){
        this.in1 = in1;
        this.in2 = in2;
    }


    /** execute the result and zero signal, this function use Gate to calculate the result
     * 
     */
    public void execute(){

        gate.setInput(in1, in2);                    // set inputs

        switch (aluCtrl) {
            case 0b0000:                            // AND
                    gate.AND();
                    result = gate.getResult(); 
                break;

            case 0b0001:                            // OR
                    gate.OR();
                    result = gate.getResult(); 
                break;

            case 0b0010:                            // ADD
                    gate.ADD();
                    result = gate.getResult(); 
                break;

            case 0b0110:                            // SUBTRACT
                    gate.SUBTRACT();
                    result = gate.getResult(); 
                    zero = gate.getZero();
                break;  

            case 0b0011:                            // NAND
                    gate.NAND();
                    result = gate.getResult(); 
                break;        
                
            case 0b1111:                            // NOOP
                    result = 0; 
                break;                 

            default:                                // other cases will get 0
                    result = 0; 
                break;
        }
    }

    
    /**
     * 
     * @return zero signal
     */
    public int getZero(){
        return zero;
    }


    /**
     * 
     * @return result of ALU
     */
    public int getResult(){
        return result;
    }

}
