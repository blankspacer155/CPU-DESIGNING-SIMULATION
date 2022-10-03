package Simulator.SubPart;

public class Mux {
    public int select(int zero, int one, int ctrl){
        return ctrl == 1 ? one : zero;
    }
}
