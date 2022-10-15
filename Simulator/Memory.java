package Simulator;

public class Memory {

    // initial
    private int[] memory;
    private int numMemory;

    // inputs
    // --------------------------------------------
    private int instrAddr;          // PC
    private int memAddr;            // Address for write or read
    private int writeData;
    // --------------------------------------------

    // controls
    // --------------------------------------------
    private int MemWrite;
    private int MemRead;
    // --------------------------------------------

    // outputs
    // --------------------------------------------
    private int instrucion;
    private int dataFromRead;
    // --------------------------------------------

    public Memory(int[] memory, int numMemory) {
        this.memory = memory;
        this.instrAddr = 0;
        this.memAddr = 0;
        MemWrite = 0;
        MemRead = 0;
        dataFromRead = 0;
        instrucion = 0;
        this.numMemory = numMemory;
    }


    // setter part
    public void setInstrAddr(int PC) {
        this.instrAddr = PC;
        instrucion = memory[instrAddr];
    }

    public void setMemAddr(int memAddr) {
        this.memAddr = memAddr;
    }

    public void setCtrlWrite(int ctrl){
        this.MemWrite = ctrl;
    }

    public void setCtrlRead(int ctrl){
        this.MemRead = ctrl;
    }

    public void setDataToWrite(int wrData){
        this.writeData = wrData;
    }

    
    // executing part
    public void readData(){
        if(MemRead == 1) 
            dataFromRead =  memory[memAddr];
    }

    public void writeData(){
        if(MemWrite == 1)
            memory[memAddr] = writeData;
    }


    // getter part
    public int getDataFromRead(){
        return dataFromRead;
    }

    public int getInstruction(){
        return instrucion;
    }

    public int[] getMemory() {
        return memory;
    }

    public int getNumMemory() {
        return numMemory;
    }
    

}
