package Simulator.Test;

import Simulator.SubPart.Gate;

public class GateTest {
    
    public static void main(String[] args) {
        Gate gate =new Gate();

        int t1 = 0b110011;
        int t2 = 0b101001;

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        
        System.out.println("MUX t1 t2 0 " + gate.MUX(t1, t2, 0) );
        System.out.println("MUX t1 t2 1 " + gate.MUX(t1, t2, 1) );

        System.out.println("AND result " + Integer.toBinaryString(gate.AND(t1, t2)));
        System.out.println("AND expect 100001 ");

        System.out.println("OR result " + Integer.toBinaryString(gate.OR(t1, t2)));
        System.out.println("OR expect 111011 ");

        System.out.println("NAND result " + Integer.toBinaryString(gate.NAND(t1, t2)));
        System.out.println("NAND expect 1...111011110 ");
        
        System.out.println("ADD result " + Integer.toBinaryString(gate.ADD(t1, t2)));
        System.out.println("ADD expect 1011100 ");

        System.out.println("SUB result " + Integer.toBinaryString(gate.SUBTRACT(t1, t2)));
        System.out.println("SUB expect 001010 ");

    }

}
