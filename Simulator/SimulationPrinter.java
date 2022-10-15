package Simulator;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class SimulationPrinter {

    public SimulationPrinter(){
        try {
            FileWriter myWriter = new FileWriter("output.txt", false);          // clear output
            FileWriter pcWriter = new FileWriter("output_PC.txt", false);       // clear output_PC 
            myWriter.close();
            pcWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    /** print only memory
     * 
     * @param memory array of memories
     * @param numMemory number of line of memory
     */
    public void printMemory(int[] memory, int numMemory){

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



    /** print whole of single stage included registers and memories
     * 
     * @param PC PC of this stage
     * @param memory array of memories
     * @param registers array of registers
     * @param numMemory number of line of used memory
     */
    public void printStage(int PC, int[] memory, int[] registers, int numMemory){

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


    /** print program conclusion
     * 
     * @param counter number of instructions
     */
    public void printEndOfProgram(int counter){

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


}
