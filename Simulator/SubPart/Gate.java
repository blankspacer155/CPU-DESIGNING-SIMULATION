package Simulator.SubPart;

public class Gate {

    // input
    // --------------------------------------------
    protected int in1;
    protected int in2;
    // --------------------------------------------

    // control
    // --------------------------------------------
    protected int control;
    // --------------------------------------------

    // outputs
    // --------------------------------------------
    protected int result;
    protected int zero;
    // --------------------------------------------

    public Gate(){
        in1 = 0;
        in2 = 0;

        control = 0;

        result = 0;
        zero = 0;
    }


    /** set inputs for gate
     * 
     * @param in1 first input
     * @param in2 second input
     */
    public void setInput(int in1, int in2) {
        this.in1 = in1;
        this.in2 = in2;
    }


    /** set control for gate (onlu use in mux)
     * 
     * @param control
     */
    public void setControl(int control) {
        this.control = control;
    }


    /**
     * 
     * @return executed result
     */
    public int getResult() {
        return result;
    }


    /**
     * 
     * @return zero signal
     */
    public int getZero() {
        return zero;
    }


    /**
     *  execute MUX
     */
    public void MUX(){
        result = control == 1 ? in2 : in1;
    }


    /**
     *  execute AND
     */
    public void AND(){
        result = in1 & in2;
    }


    /**
     *  execute OR
     */
    public void OR(){
        result = in1 | in2;
    }


    /**
     *  execute NAND 32 bits
     */
    public void NAND(){

        result = in1 & in2;                         // AND the inputs

        for(int i = 0; i <= 31; i ++){              // then 32 bits NOT, so we get NAND
            if(((result >> (i)) & 1) == 1){
                result = result - (1 << i);
            }else{
                result = result + (1 << i);
            } 
        }
 
    }


    /**
     *  execute ADD
     */
    public void ADD(){
        result = in1 + in2;
    }


    /**
     *  execute SUBTRACT
     */
    public void SUBTRACT(){
        result = in1 - in2;
        zero = result == 0 ? 1 : 0;
    }
    
}
