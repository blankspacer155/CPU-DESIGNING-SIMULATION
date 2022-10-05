package Simulator.Test;

import Simulator.SubPart.Gate;

public class GateTest {
    
    public static void main(String[] args) {
        Gate gate =new Gate();

        int t1 = 0b110011;
        int t2 = 0b101001;

        gate.setInput(t1, t2);


        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        
        gate.setControl(0);
        gate.MUX();
        System.out.println("MUX t1 t2 0 " + gate.getResult() );
        gate.setControl(1);
        gate.MUX();
        System.out.println("MUX t1 t2 1 " + gate.getResult() );

        gate.AND();
        System.out.println("AND result " + Integer.toBinaryString(gate.getResult()));
        System.out.println("AND expect 100001 ");

        gate.OR();
        System.out.println("OR result " + Integer.toBinaryString(gate.getResult()));
        System.out.println("OR expect 111011 ");

        gate.NAND();
        System.out.println("NAND result " + Integer.toBinaryString(gate.getResult()));
        System.out.println("NAND expect 1...111011110 ");
        
        gate.ADD();
        System.out.println("ADD result " + Integer.toBinaryString(gate.getResult()));
        System.out.println("ADD expect 1011100 ");

        gate.SUBTRACT();
        System.out.println("SUB result " + Integer.toBinaryString(gate.getResult()));
        System.out.println("SUB expect 001010 ");

    }

}
