package Parser.Grammars;

import java.util.Map;



public class Symbolic implements Expression{
    private String label;

    public Symbolic(String label){
        this.label = label;
    }
    @Override
    public int eval( Map<String, Expression> binding) {
        if(binding==null){
            throw new RuntimeException("undefined label");
        }

        int value = binding.get(label).eval(binding); //get value from label name
       return value;
    }
    public void set(Map<String,Integer> binding,int value){
        binding.put(label,value);
    }

    
}
