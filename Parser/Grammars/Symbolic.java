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
    //    if(binding.get(label)==null){  //init first time ever seen
    //        binding.put(label,new Number(0));
    //     }

        int value = binding.get(label).eval(binding);
       // System.out.println("symbolic:"+label+" ="+value);
       return value;
    }
    public void set(Map<String,Integer> binding,int value){
        binding.put(label,value);
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        // TODO Auto-generated method stub
        
    }
    
}
