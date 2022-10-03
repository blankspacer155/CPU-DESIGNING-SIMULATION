package Simulator.SubPart;

public class ImmGen {
    public int generate(int imm){
        if (((imm >> 15) & 1) == 1){
            return -(imm & 0b111111111111111);
        }else
            return imm & 0b1111111111111111;
    }
}

