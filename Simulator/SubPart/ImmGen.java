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

    /**
     * execute 16 -> 32 bits
     */
    public void excute(){
        if (((input >> 15) & 1) == 1){                  // if input is 2's complement negative
            output = input & 0b1111111111111111;                // get 16 bits input
                             
            for(int i = 0; i <= 15; i ++){              // 16 bits NOT (flips input bits)
                if(((output >> (i)) & 1) == 1){
                    output = output - (1 << i);
                }else{
                    output = output + (1 << i);
                } 
            }

            output &= 0b1111111111111111;
            output = -(output + 1);                     // then + 1, so we get negative 32 bits
        }else
            output =  input & 0b1111111111111111;
    }


    /** set input for converting
     * 
     * @param input 2's complement 16 bits
     */
    public void setInput(int input) {
        output = 0;
        this.input = input;
    }


    /**
     * 
     * @return output binary 32 bits
     */
    public int getOutput() {
        return output;
    }
}

