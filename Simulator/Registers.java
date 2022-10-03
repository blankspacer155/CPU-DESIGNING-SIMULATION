package Simulator;

import Simulator.SubPart.Address;

public class Registers {
    protected int[] registers;
    protected Address regA;
    protected Address regB;
    protected Address wrReg;
    protected int RegWrite;

    public Registers() {
        registers = new int[8];
        regA = new Address(0);
        regB = new Address(0);
        wrReg = new Address(0);
        RegWrite = 0;
    }

    public void setRegA(int regA) {
        this.regA.setValue(regA);;
    }

    public void setRegB(int regB) {
        this.regB.setValue(regB);;
    }

    public void setWrReg(int wrReg) {
        this.wrReg.setValue(wrReg);;
    }

    public int readDataA(){
        return registers[regA.getValue()];
    }
    
    public int readDataB(){
        return registers[regB.getValue()];
    }

    public void setWriteCtrl(int ctrl){
        this.RegWrite = ctrl;
    }

    public void WriteData(int wrData){
        if(RegWrite == 1)
            registers[wrReg.getValue()] = wrData;
    }
    
}
