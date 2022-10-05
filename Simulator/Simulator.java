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
    }

    public void setMachineCode(int[] machineCode){
        memory = new Memory(machineCode);
    }

    public void run(){

        for (int i = 0; i < 100 && !instrReg.isHalt && PC < memory.getMemory().length && PC >= 0 ; i++) {
            
            if(counter == 0){
                // print memory before run whole program
                simPr.printMemory(memory.getMemory());
            } 

            simPr.printStage(PC, memory.getMemory(), registers.getRegisters());
            
            memory.setInstrAddr(PC);
            
            instrReg.setInstr(memory.getInstruction());

            immGen.setInput(memory.getInstruction());
            immGen.excute();

            control.setopcode(instrReg.instr24_22);
            control.excuteControl();

            registers.setRegA(instrReg.instr21_19);
            registers.setRegB(instrReg.instr18_16);
            registers.readDataA();
            registers.readDataB();

            gates[0].setControl(control.getRegDst());
            gates[0].setInput(instrReg.instr18_16, instrReg.instr2_0);
            gates[0].MUX();

            registers.setWrReg(gates[0].getResult());

            gates[2].setControl(control.getALUsrc());
            gates[2].setInput(registers.getDataFromReadB(), immGen.getOutput());
            gates[2].MUX();

            aluCtrl.setInput(control.getALUop());
            aluCtrl.excuteCtrl();

            alu.setCtrl(aluCtrl.getAluCtrl());
            alu.setInput(registers.getDataFromReadA(), gates[2].getResult());
            alu.excute();

            gates[6].setInput(PC, 1);
            gates[6].ADD();

            gates[7].setInput(PC, immGen.getOutput());
            gates[7].ADD();

            gates[3].setControl(control.getJump());
            gates[3].setInput(gates[7].getResult(), registers.getDataFromReadA());
            gates[3].MUX();

            gates[8].setInput(control.getBranch(), alu.getZero());
            gates[8].AND();

            gates[9].setInput(gates[8].getResult(), control.getJump());
            gates[9].OR();

            gates[4].setControl(gates[9].getResult());
            gates[4].setInput(gates[6].getResult(), gates[3].getResult());
            gates[4].MUX();

            gates[5].setControl(control.Jump);
            gates[5].setInput(alu.getResult(), gates[6].getResult());
            gates[5].MUX();

            memory.setMemAddr(gates[5].getResult());

            memory.setCtrlWrite(control.getMemWrite());
            memory.setDataToWrite(registers.getDataFromReadB());
            memory.writeData();

            memory.setCtrlRead(control.getMemRead());
            memory.readData();

            gates[1].setControl(control.getMemToReg());
            gates[1].setInput(gates[5].getResult(), memory.getDataFromRead());
            gates[1].MUX();

            registers.setWriteCtrl(control.getRegWr());
            registers.setDataToWrite(gates[1].getResult());
            registers.WriteData();
            
            PC = gates[4].getResult();

            counter++;

        }

        simPr.printEndOfProgram(counter);
        simPr.printStage(PC, memory.getMemory(), registers.getRegisters());

    }

    
}
