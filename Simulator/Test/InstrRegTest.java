package Simulator.Test;

import Simulator.InstructionRegister;

public class InstrRegTest {
    
    public static void main(String[] args){

        InstructionRegister ir = new InstructionRegister();
        ir.setInstr(8454151);

        System.out.println("Instruction");
        System.out.println("Decimal:  8454151" );
        System.out.println("Binary:  " + Integer.toBinaryString(8454151));

        System.out.println("Instruction 24-22");
        System.out.println(Integer.toBinaryString(ir.getInstr24_22()));

        System.out.println("Instruction 21-19");
        System.out.println(Integer.toBinaryString(ir.getInstr21_19()));

        System.out.println("Instruction 18-16");
        System.out.println(Integer.toBinaryString(ir.getInstr18_16()));

        System.out.println("Instruction 2-0");
        System.out.println(Integer.toBinaryString(ir.getInstr2_0()));

    }

}
