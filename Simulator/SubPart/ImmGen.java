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
    
    public ImmGen() {
        input = 0;
        output = 0;
    }


    public void excute(){
        if (((input >> 15) & 1) == 1){
            input &= 0b1111111111111111;
            output = input & input;

            // 16 bits nand
            for(int i = 0; i <= 15; i ++){
                if(((output >> (i)) & 1) == 1){
                    output = output - (1 << i);
                }else{
                    output = output + (1 << i);
                } 
            }

            output &= 0b1111111111111111;
            output = -(output + 1);
        }else
            output =  input & 0b1111111111111111;
    }

    public void setInput(int input) {
        output = 0;
        this.input = input;
    }

    public int getOutput() {
        return output;
    }
}

