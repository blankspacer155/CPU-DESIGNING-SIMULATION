package Parser.Grammars;

public class StringBaseConverter {
    private static StringBaseConverter instance;

     private StringBaseConverter(){
    }

    public static StringBaseConverter getInstance(){
        if(instance==null){
           instance = new StringBaseConverter();
        }
        return instance;
    }

    //convert machine code that in string  to decimal 
    public int convertToDeci(String machine_S){
        return  Integer.parseInt(machine_S,2);
    }
    //convert to hexadecimal  from decimal
    public String convertToHex(int machine_deci){
        String machine_hex= Integer.toHexString(machine_deci);
        machine_hex = new String("0x").concat(machine_hex);
        return machine_hex;
    }
    //convert decimal to binary string
    public String convertToBinStr(int value,int bitNum,String ext){
       String str = Integer.toBinaryString(value);
        str = String.format("%"+Integer.toString(bitNum)+"s", str).replaceAll(" ", ext);
        if(ext.equals("1")){ //negative number
            str = str.substring(32-bitNum);
        }
        return str;
    }
}
