package Simulator.Test;

import Simulator.SubPart.ImmGen;

public class ImmGenTest {

    

    public static void main(String[] args) {
        
        ImmGen imgn = new ImmGen();

        int t1 = 0b1000000000000001;

        int t2 = 0b0000000000000111;

        int t3 = 0b100000000000000011;

        System.out.println(t1 +  " -> " + imgn.generate(t1));

        System.out.println(t2 +  " -> " + imgn.generate(t2));

        System.out.println(t3 +  " -> " + imgn.generate(t3));


    }
    
}
