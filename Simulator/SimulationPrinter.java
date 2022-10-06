package Simulator;

public class SimulationPrinter {
    
    public void printMemory(int[] memory){

        for (int i = 0; i < memory.length; i++) {
            System.out.println("memory[" + i + "]=" + memory[i]);
        }
        System.out.println();
        System.out.println();
    }

    public void printStage(int PC, int[] memory, int[] registers){
        System.out.println("@@@");
        System.out.println("state:");
        System.out.println("      pc " + PC);

        System.out.println("      memory:");
        for (int i = 0; i < memory.length; i++) {
            System.out.println("             mem[ " + i + " ] " + memory[i]);
        }

        System.out.println("      registers:");
        for (int i = 0; i < registers.length; i++) {
            System.out.println("             reg[ " + i + " ] " + registers[i]);
        }

        System.out.println(" end state");
        System.out.println();

    }

    public void printEndOfProgram(int counter){
        System.out.println("machine halted");
        System.out.println("total of " + counter + " instructions excuted");
        System.out.println("final stage of program");
        System.out.println();

    }

    public void printMemoryBinary(int[] memory){

        for (int i = 0; i < memory.length; i++) {
            System.out.println("memory[" + i + "]=" + Integer.toBinaryString(memory[i]));
        }
    }

    public void printStageBinary(int PC, int[] memory, int[] registers){
        System.out.println("@@@");
        System.out.println("state:");
        System.out.println("      pc " + PC);

        System.out.println("      memory:");
        for (int i = 0; i < memory.length; i++) {
            System.out.println("             mem[" + i + "] " + Integer.toBinaryString(memory[i]));
        }

        System.out.println("      registers:");
        for (int i = 0; i < registers.length; i++) {
            System.out.println("             reg[" + i + "] " + registers[i]);
        }

        System.out.println(" end state");
        System.out.println();

    }



}
