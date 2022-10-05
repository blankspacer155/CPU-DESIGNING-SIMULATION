package Simulator.Test;

import Simulator.SubPart.ImmGen;

public class ImmGenTest {

    

    public static void main(String[] args) {
        
        ImmGen imgn = new ImmGen();

        int t1 = 0b1000000000000001;

        int t2 = 0b0000000000000111;

        int t3 = 0b100000000000000011;

        int t4 = -24;

        imgn.setInput(t1);
        imgn.excute();
        System.out.println(t1 +  " -> " + imgn.getOutput());

        imgn.setInput(t2);
        imgn.excute();
        System.out.println(t2 +  " -> " + imgn.getOutput());

        imgn.setInput(t3);
        imgn.excute();
        System.out.println(t3 +  " -> " + imgn.getOutput());

        imgn.setInput(t4);
        imgn.excute();
        System.out.println(Integer.toBinaryString(t4));
        System.out.println(t4 +  " -> " + imgn.getOutput());


    }
    
}
