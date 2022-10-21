package Simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimulationReader {

    private int index;

    /** read machine code from file machinecode.txt  
     * 
     * @param memory array of int which no any data
     * @return the same array of int with instructions and data 
     */
    public int[] readProgram(int[] memory){

        try(BufferedReader reader = new BufferedReader(new FileReader("machinecode.txt"))){
            String line;
            index = 0;
    
            while ((line = reader.readLine()) != null) {
                 memory[index] = Integer.parseInt(line);
                 index++;
           }

            return memory;
        }
        catch(IOException err){
            System.out.println(err);
            return null;
        }

    }

    public int getNumMemory() {
        return index;
    }

}
