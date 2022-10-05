package Simulator.Test;

import Simulator.Control;

public class ControlTest {

    public static void main(String[] args){

        Control c = new Control();

        c.setopcode(0b010);      // LW
        c.excuteControl();

        System.out.println("LW");
        System.out.println("MemWrite: " + c.getMemWrite());
        System.out.println("MemRead: " + c.getMemRead());
        System.out.println("MemToReg: " + c.getMemToReg());
        System.out.println("Brancg: " + c.getBranch());
        System.out.println("Jump: " + c.getJump());
        System.out.println("ALUsrc: " + c.getALUsrc());
        System.out.println("ALUop: 0b" + Integer.toBinaryString(c.getALUop()));
        System.out.println("RegWrite: " + c.getRegWr());
        System.out.println("RegDst: " + c.getRegDst());

        c.reset();
        
        c.setopcode(0b101);
        c.excuteControl();

        System.out.println("JALR");
        System.out.println("MemWrite: " + c.getMemWrite());
        System.out.println("MemRead: " + c.getMemRead());
        System.out.println("MemToReg: " + c.getMemToReg());
        System.out.println("Brancg: " + c.getBranch());
        System.out.println("Jump: " + c.getJump());
        System.out.println("ALUsrc: " + c.getALUsrc());
        System.out.println("ALUop: 0b" + Integer.toBinaryString(c.getALUop()));
        System.out.println("RegWrite: " + c.getRegWr());
        System.out.println("RegDst: " + c.getRegDst());
    }
    
}
