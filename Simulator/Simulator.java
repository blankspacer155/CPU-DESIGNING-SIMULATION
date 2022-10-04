package Simulator;

import Simulator.SubPart.Gate;
import Simulator.SubPart.ImmGen;

import javax.swing.text.html.HTML;

import Simulator.SubPart.Address;

public class Simulator {
    protected int PC;
    protected int counter;
    protected boolean halt;

    protected Memory memory;
    protected InstructionRegister instrReg;
    protected Registers registers;
    protected Control control;
    protected ALUControl aluCtrl;

    protected Gate gate;
    protected ImmGen immGen;

    public Simulator(int[] machineCode){
        PC = 0;
        counter = 0;
        halt = false;

        memory = new Memory(machineCode);
        instrReg = new InstructionRegister();
        registers = new Registers();
        control = new Control();
        aluCtrl = new ALUControl();

        gate = new Gate();
        immGen = new ImmGen();
    }

    public void run(){
        
    }

    
}
