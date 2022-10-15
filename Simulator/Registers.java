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


    /** set address for Reading regA
     * 
     * @param regA
     */
    public void setRegA(int regA) {
        this.regA = regA;
    }


    /** set address for Reading regB
     * 
     * @param regB
     */
    public void setRegB(int regB) {
        this.regB = regB;
    }


    /** set address for writing to register
     * 
     * @param wrReg
     */
    public void setWrReg(int wrReg) {
        this.wrReg = wrReg;
    }


    /** read data at address regA
     * 
     */
    public void readDataA(){
        dataFromReadA =  registers[regA];
    }
    

    /** read data at address regB
     * 
     */
    public void readDataB(){
        dataFromReadB =  registers[regB];
    }


    /**
     * 
     * @return data at address regA
     */
    public int getDataFromReadA() {
        return dataFromReadA;
    }


    /**
     * 
     * @return data at address regB
     */
    public int getDataFromReadB() {
        return dataFromReadB;
    }


    /** set regWrite control
     * 
     * @param ctrl regWrite
     */
    public void setWriteCtrl(int ctrl){
        this.RegWrite = ctrl;
    }


    /** set data for writing to register
     * 
     * @param dataToWrite
     */
    public void setDataToWrite(int dataToWrite) {
        this.dataToWrite = dataToWrite;
    }


    /** write data to register at address wrReg
     * 
     */
    public void WriteData(){
        if(RegWrite == 1)
            registers[wrReg] = dataToWrite;
    }


    /**
     * 
     * @return array of registers
     */
    public int[] getRegisters() {
        return registers;
    } 


    /**
     * 
     * @return value in register 5 (stack pointer)
     */
    public int getStackPointerValue() {
        return registers[5];
    } 
    
}
