package Simulator;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class SimulationPrinter {

    public SimulationPrinter(){
        try {
            FileWriter myWriter = new FileWriter("output.txt", false);
            FileWriter pcWriter = new FileWriter("output_PC.txt", false);
            myWriter.close();
            pcWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
    public void printMemory(int[] memory, int numMemory){

        // for (int i = 0; i < memory.length; i++) {
        //     System.out.println("memory[" + i + "]=" + memory[i]);
        // }

        // System.out.println();
        // System.out.println();

        try {
            FileWriter myWriter = new FileWriter("output.txt", true);

            for (int i = 0; i < numMemory; i++) {
                myWriter.write("memory[" + i + "]=" + memory[i] + "\n");     
            }
            myWriter.write("\n");

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    public void printStage(int PC, int[] memory, int[] registers, int numMemory){
        // System.out.println("@@@");
        // System.out.println("state:");
        // System.out.println("      pc " + PC);

        // System.out.println("      memory:");
        // for (int i = 0; i < memory.length; i++) {
        //     System.out.println("             mem[ " + i + " ] " + memory[i]);
        // }

        // System.out.println("      registers:");
        // for (int i = 0; i < registers.length; i++) {
        //     System.out.println("             reg[ " + i + " ] " + registers[i]);
        // }

        // System.out.println("end state");
        // System.out.println();

        try {
            FileWriter myWriter = new FileWriter("output.txt", true);
            FileWriter pcWriter = new FileWriter("output_PC.txt", true);

            myWriter.write("\n");
            myWriter.write("@@@\n");
            myWriter.write("state:\n");
            myWriter.write("      pc " + PC + "\n");
            pcWriter.write("      pc " + PC + "\n");

            myWriter.write("      memory:\n");
            for (int i = 0; i < numMemory; i++) {
                myWriter.write("             mem[ " + i + " ] " + memory[i] + "\n");
            }
    
            myWriter.write("      registers:\n");
            for (int i = 0; i < registers.length; i++) {
                myWriter.write("             reg[ " + i + " ] " + registers[i] + "\n");
            }
    
            myWriter.write("end state\n");
            
            pcWriter.close();
            myWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void printEndOfProgram(int counter){

        // System.out.println("machine halted");
        // System.out.println("total of " + counter + " instructions excuted");
        // System.out.println("final stage of program");
        // System.out.println();

        try {
            FileWriter myWriter = new FileWriter("output.txt", true);
            FileWriter pcWriter = new FileWriter("output_PC.txt", true);

            myWriter.write("machine halted\n");
            myWriter.write("total of " + counter + " instructions excuted\n");
            myWriter.write("final stage of program\n");
            pcWriter.write("machine halted\n");
            pcWriter.write("total of " + counter + " instructions excuted\n");
            pcWriter.write("final stage of program\n");
            
            pcWriter.close();
            myWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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
