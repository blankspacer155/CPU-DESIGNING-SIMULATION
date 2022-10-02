package Simulator;

import Simulator.SubPart.Address;

public class Memory {
    private int[] memory;
    private Address instrAddr;
    private Address memAddr;
    private int MemWrite;
    private int MemRead;

    public Memory(int[] memory) {
        this.memory = memory;
        this.instrAddr = new Address(0);
        this.memAddr = new Address(0);
        MemWrite = 0;
        MemRead = 0;
    }

    public void setInstrAddr(int PC) {
        this.instrAddr.setValue(PC);
    }

    public void setMemAddr(int memAddr) {
        this.memAddr.setValue(memAddr);
    }

    public void setCtrlWrite(int ctrl){
        this.MemWrite = ctrl;
    }

    public void setCtrlRead(int ctrl){
        this.MemRead = ctrl;
    }

    public void writeData(int wrData){
        if(MemWrite == 1)
            memory[memAddr.getValue()] = wrData;
    }

    public int getInstruction(){
        return memory[instrAddr.getValue()];
    }

    public int readData(){
        if(MemRead == 1) 
            return memory[memAddr.getValue()];
        else
            return 0; 
    }

    

    
    
   

    
    

    

    

}
