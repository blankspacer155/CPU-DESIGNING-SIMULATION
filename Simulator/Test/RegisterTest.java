package Simulator.Test;

import Simulator.Registers;

public class RegisterTest {

    public static void  main(String[] args){
        Registers regs = new Registers();

        regs.setRegA(0);
        regs.setRegB(1);

        System.out.println("regA");
        System.out.println(regs.readDataA());
        System.out.println("regB");
        System.out.println(regs.readDataB());

        regs.setWrReg(0);

        regs.setWriteCtrl(0);
        regs.WriteData(19);

        System.out.println("write regA with ctrl 0");
        System.out.println(regs.readDataA());

        regs.setWriteCtrl(1);
        regs.WriteData(19);

        System.out.println("write regA with ctrl 1");
        System.out.println(regs.readDataA());


        regs.setWrReg(1);
        regs.setWriteCtrl(1);
        regs.WriteData(512);

        System.out.println("write regB with ctrl 1");
        System.out.println(regs.readDataB());


    }
}
