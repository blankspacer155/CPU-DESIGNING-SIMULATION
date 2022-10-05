package Simulator;

public class Memory {

    // initial
    private int[] memory;

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

    public Memory(int[] memory) {
        this.memory = memory;
        this.instrAddr = 0;
        this.memAddr = 0;
        MemWrite = 0;
        MemRead = 0;
        dataFromRead = 0;
        instrucion = 0;
    }


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


    public int getInstruction(){
        return instrucion;
    }

    public void readData(){
        if(MemRead == 1) 
            dataFromRead =  memory[memAddr];
    }

    public int getDataFromRead(){
        return dataFromRead;
    }

    public void setDataToWrite(int wrData){
        this.writeData = wrData;
    }

    public void writeData(){
        if(MemWrite == 1)
            memory[memAddr] = writeData;
    }


    public int[] getMemory() {
        return memory;
    }

    

    
    
   

    
    

    

    

}
