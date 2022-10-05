package Simulator;

public class Registers {

    // initial
    protected int[] registers;

    // inputs
    // --------------------------------------------
    protected int regA;
    protected int regB;
    protected int wrReg;
    protected int dataToWrite;
    // --------------------------------------------


    // control
    // --------------------------------------------
    protected int RegWrite;
    // --------------------------------------------

    // outputs
    // --------------------------------------------
    protected int dataFromReadA;
    protected int dataFromReadB;
    // --------------------------------------------

    public Registers() {
        registers = new int[8];
        regA = 0;
        regB = 0;
        wrReg = 0;
        dataToWrite = 0;
        RegWrite = 0;
    }

    public void setRegA(int regA) {
        this.regA = regA;
    }

    public void setRegB(int regB) {
        this.regB = regB;
    }

    public void setWrReg(int wrReg) {
        this.wrReg = wrReg;
    }

    public void readDataA(){
        dataFromReadA =  registers[regA];
    }
    
    public void readDataB(){
        dataFromReadB =  registers[regB];
    }

    public int getDataFromReadA() {
        return dataFromReadA;
    }

    public int getDataFromReadB() {
        return dataFromReadB;
    }

    public void setWriteCtrl(int ctrl){
        this.RegWrite = ctrl;
    }

    public void setDataToWrite(int dataToWrite) {
        this.dataToWrite = dataToWrite;
    }

    public void WriteData(){
        if(RegWrite == 1)
            registers[wrReg] = dataToWrite;
    }

    public int[] getRegisters() {
        return registers;
    } 

    
    
}
