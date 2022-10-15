package Simulator.Test;

import Simulator.Memory;

public class MemoryTest {

    public static void  main(String[] args){
        int[] t = new int[2];
        t[0] = 8454151;
        t[1] = 29;
        
        Memory mem = new Memory(t,2);

        mem.setInstrAddr(0);

        System.out.println("Instruction");
        System.out.println("Decimal:  " + mem.getInstruction());
        System.out.println("Binary:  " + Integer.toBinaryString(mem.getInstruction()));


        mem.setCtrlRead(1);
        mem.setMemAddr(1);

        mem.readData();

        System.out.println("ReadMem");
        System.out.println(mem.getDataFromRead());

        
        mem.setCtrlWrite(0);
        mem.setDataToWrite(32);

        mem.writeData();

        mem.readData();

        System.out.println("WriteMem with ctrl 0");
        System.out.println(mem.getDataFromRead());

        mem.setCtrlWrite(1);
       
        mem.writeData();

        mem.readData();

        System.out.println("WriteMem with ctrl 1");
        System.out.println(mem.getDataFromRead());

    }
    
}
