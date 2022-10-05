package Simulator.SubPart;

public class ImmGen {

    // input
    // --------------------------------------------
    protected int input;
    // --------------------------------------------

    // outputs
    // --------------------------------------------
    protected int output;
    // --------------------------------------------

    // gate for 2's complement
    // --------------------------------------------
    protected Gate gate;
    // --------------------------------------------

    
    public ImmGen() {
        input = 0;
        output = 0;
        gate = new Gate();
    }


    public void excute(){
        if (((input >> 15) & 1) == 1){
            input &= 0b1111111111111111;
            gate.setInput(input, input);
            gate.NAND();
            input &= 0b1111111111111111;
            output = -(gate.getResult() + 1);
        }else
            output =  input & 0b1111111111111111;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }
}

