package Simulator.Test;

import Simulator.Registers;

public class RegisterTest {

    public static void  main(String[] args){
        Registers regs = new Registers();

        regs.setRegA(0);
        regs.setRegB(1);

        System.out.println("regA");
        regs.readDataA();
        System.out.println(regs.getDataFromReadA());

        System.out.println("regB");
        regs.readDataB();
        System.out.println(regs.getDataFromReadB());

        regs.setWrReg(0);

        regs.setWriteCtrl(0);
        regs.setDataToWrite(19);
        regs.WriteData();

        System.out.println("write regA with ctrl 0");
        regs.readDataA();
        System.out.println(regs.getDataFromReadA());

        regs.setWriteCtrl(1);
        regs.WriteData();

        System.out.println("write regA with ctrl 1");
        regs.readDataA();
        System.out.println(regs.getDataFromReadA());


        regs.setWrReg(1);
        regs.setWriteCtrl(1);
        regs.setDataToWrite(512);
        regs.WriteData();

        System.out.println("write regB with ctrl 1");
        regs.readDataB();
        System.out.println(regs.getDataFromReadB());


    }
}
