package Simulator;

import Simulator.SubPart.Gate;
import Simulator.SubPart.ImmGen;

public class Simulator {
    protected int PC;
    protected int counter;
    protected boolean halt;

    protected Memory memory;
    protected InstructionRegister instrReg;
    protected Registers registers;
    protected Control control;
    protected ALUControl aluCtrl;
    protected ALU alu;

    protected Gate[] gates;
    protected ImmGen immGen;

    protected SimulationPrinter simPr;
    protected SimulationReader simRd;

    public Simulator(){
        PC = 0;
        counter = 0;
        halt = false;
        

        instrReg = new InstructionRegister();
        registers = new Registers();
        control = new Control();
        aluCtrl = new ALUControl();
        alu = new ALU();

        gates = new Gate[10];
        gates[0] = new Gate();      //mux to WriteReg
        gates[1] = new Gate();      //mux to Write data
        gates[2] = new Gate();      //mux to ALU
        gates[3] = new Gate();      //mux to MUX
        gates[4] = new Gate();      //MUX to  PC
        gates[5] = new Gate();      //mux to Memory address
        gates[6] = new Gate();      //ADD PC+1
        gates[7] = new Gate();      //ADD to mux
        gates[8] = new Gate();      //AND
        gates[9] = new Gate();      //OR


        immGen = new ImmGen();

        simPr = new SimulationPrinter();
        simRd = new SimulationReader();
    }


    /** set machine code for running
     */
    public void setMachineCode(){

        int[] Memory = new int[65536];
        simRd.readProgram(Memory);

        memory = new Memory(Memory, simRd.getNumMemory());
    }


    public void run(){

        for (int i = 0; i < 65536 && !instrReg.isHalt &&
             PC < memory.getMemory().length && PC >= 0 ; i++) {                 // only loops for 700 times , can increse loop times later
                                                                                // (avoid run too much if it has bug about halting)
            
            if(counter == 0)                                                    // print memory before run whole program
                simPr.printMemory(memory.getMemory(),
                    memory.getNumMemory() + registers.getStackPointerValue());
            
            
            memory.setInstrAddr(PC);                                            // PC -> get instruction from memory
            
            instrReg.setInstr(memory.getInstruction());                         // get each parts from instruction


            simPr.printStage(PC,                                                // print stage before run
                             memory.getMemory(),                            
                             registers.getRegisters(),          
                             memory.getNumMemory() > registers.getStackPointerValue() 
                                ? memory.getNumMemory() : registers.getStackPointerValue());


            // IMM GEN
            immGen.setInput(memory.getInstruction());                           
            immGen.excute();


            // CONTROL
            control.setopcode(instrReg.instr24_22);                             
            control.executeControl();


            // REGISTERS
            // read dataA and dataB
            registers.setRegA(instrReg.instr21_19);                             
            registers.setRegB(instrReg.instr18_16);
            registers.readDataA();
            registers.readDataB();

            
            // MUX 0-1 select between regB or wrReg to WriteRegister
            gates[0].setControl(control.getRegDst());
            gates[0].setInput(instrReg.instr18_16, instrReg.instr2_0);
            gates[0].MUX();

            registers.setWrReg(gates[0].getResult());


            // MUX 0-1 select between data from readB or imm to second input of ALU
            gates[2].setControl(control.getALUsrc());
            gates[2].setInput(registers.getDataFromReadB(), immGen.getOutput());
            gates[2].MUX();


            // ALUCONTROL
            // execute aluctrl for ALU
            aluCtrl.setInput(control.getALUop());
            aluCtrl.executeCtrl();


            // ALU
            // get input from data from readA and MUX the execute
            alu.setCtrl(aluCtrl.getAluCtrl());
            alu.setInput(registers.getDataFromReadA(), gates[2].getResult());
            alu.execute();


            // ADDER: PC + 1
            gates[6].setInput(PC, 1);
            gates[6].ADD();


            // ADDER: (PC + 1) + imm
            gates[7].setInput(gates[6].getResult(), immGen.getOutput());
            gates[7].ADD();


            // MUX 0-1 select between (PC + 1) + imm or data from readA to MUX (gate[4])
            gates[3].setControl(control.getJump());
            gates[3].setInput(gates[7].getResult(), registers.getDataFromReadA());
            gates[3].MUX();


            // AND: Branch control and Zero signal
            gates[8].setInput(control.getBranch(), alu.getZero());
            gates[8].AND();


            // OR: result from above AND and Jump control
            gates[9].setInput(gates[8].getResult(), control.getJump());
            gates[9].OR();


            // MUX 0-1 select between PC + 1  or result from MUX (gate[3]) to Write to PC
            gates[4].setControl(gates[9].getResult());
            gates[4].setInput(gates[6].getResult(), gates[3].getResult());
            gates[4].MUX();


            // MUX 0-1 select between result from ALU  or PC +1 to write/read address of Memory and MUX (gate[1])
            gates[5].setControl(control.Jump);
            gates[5].setInput(alu.getResult(), gates[6].getResult());
            gates[5].MUX();


            // MEMORY
            // set address for writing or reading
            memory.setMemAddr(gates[5].getResult());

            // write data from readB to MEMORY
            memory.setCtrlWrite(control.getMemWrite());
            memory.setDataToWrite(registers.getDataFromReadB());
            memory.writeData();

            // read MEMORY
            memory.setCtrlRead(control.getMemRead());
            memory.readData();


            // MUX 0-1 select between result from MUX (gate[5]) or data from MEMORY to Write to register
            gates[1].setControl(control.getMemToReg());
            gates[1].setInput(gates[5].getResult(), memory.getDataFromRead());
            gates[1].MUX();


            // REGISTERS
            // write to register
            registers.setWriteCtrl(control.getRegWr());
            registers.setDataToWrite(gates[1].getResult());
            registers.WriteData();
            

            // write PC
            PC = gates[4].getResult();

            counter++;

        }

        // after finish running, print conclusion of Program and last stage
        simPr.printEndOfProgram(counter);
        simPr.printStage(PC, memory.getMemory(), registers.getRegisters(), memory.getNumMemory() + registers.getStackPointerValue());

    }

    
}
