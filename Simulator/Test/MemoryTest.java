package Simulator.Test;

import Simulator.Memory;
import Simulator.SubPart.Address;

public class MemoryTest {

    public static void  main(String[] args){
        int[] t = new int[2];
        t[0] = 8454151;
        t[1] = 29;
        
        Memory mem = new Memory(t);

        mem.setInstrAddr(0);

        System.out.println("Instruction");
        System.out.println("Decimal:  " + mem.getInstruction());
        System.out.println("Binary:  " + Integer.toBinaryString(mem.getInstruction()));


        mem.setCtrlRead(1);
        mem.setMemAddr(1);

        System.out.println("ReadMem");
        System.out.println(mem.readData());

        
        mem.setCtrlWrite(0);
        mem.writeData(32);

        System.out.println("WriteMem with ctrl 0");
        System.out.println(mem.readData());

        mem.setCtrlWrite(1);
        mem.writeData(32);

        System.out.println("WriteMem with ctrl 1");
        System.out.println(mem.readData());

    }
    
}
