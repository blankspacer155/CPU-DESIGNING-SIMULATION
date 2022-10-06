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


    public void setInput(int in1, int in2) {
        this.in1 = in1;
        this.in2 = in2;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public int getResult() {
        return result;
    }

    public int getZero() {
        return zero;
    }

    public void MUX(){
        result = control == 1 ? in2 : in1;
    }

    public void AND(){
        result = in1 & in2;
    }

    public void OR(){
        result = in1 | in2;
    }

    public void NAND(){

        result = in1 & in2;

        for(int i = 0; i <= 31; i ++){
            if(((result >> (i)) & 1) == 1){
                result = result - (1 << i);
            }else{
                result = result + (1 << i);
            } 
        }
 
    }

    public void ADD(){
        result = in1 + in2;
    }

    public void SUBTRACT(){
        result = in1 - in2;
        zero = result == 0 ? 1 : 0;
    }

    public static void main(String[] args){
        // just for test

        int in1 = 0b1101011010110011;
        int in2 = 0b1010110011111011;
        // expect 0b0111101101001100
        String in1_str = String.valueOf(Integer.toBinaryString(in1));
        String in2_str = String.valueOf(Integer.toBinaryString(in2));

        // int c = 0;
        // int ans = 0;
        // for(int i = 1; i <= (1 << 15); i <<= 1){
        //     int x1 = in1 & i;
        //     int x2 = in2 & i;
        //     if((x1 & x2) == 0){
        //         ans = ans | i;
        //     }
        //     c++;
        // }

        // in1 >>= 16;
        // in2 >>= 16;

        // int ans2 = 0;
        // for(int i = 1; i <= (1 << 15); i <<= 1){
        //     int x1 = in1 & i;
        //     int x2 = in2 & i;
        //     if((x1 & x2) == 0){
        //         ans2 = ans2 | i;
        //     }
        //     c++;
        // }

        int result = in1 & in2;

        for(int i = 0; i <= 31; i ++){
            if(((result >> (i)) & 1) == 1){
                result = result - (1 << i);
            }else{
                result = result | (1 << i);
            }
            
        }


        System.out.println("in1 : " + in1_str);
        System.out.println("in2 : " + in2_str);
        // System.out.println("count : " + c);
        System.out.println("result : " + String.valueOf(Integer.toBinaryString(result)));
        // System.out.println("ans2 : " + String.valueOf(Integer.toBinaryString(ans2)));
    }

    
}
