/*Aseembly Exponential
        ""+
        
        
        
        "      lw   0 3 one iterator = 1\n" +
        "      lw   0 2 sign $2 = 1073741824  \n" + 
        "      lw   0 6 mcand   $6 = mcand  \n" + 
        "      lw   0 7 mplier $7 = mplier  \n" +
        "mul   nand 7  3  5 (plier nand iterator) = temp \n" + 
        "      nand 5 5  5  (temp nand temp) = temp \n" + 
        "      beq  0 5 2  if(temp == zero) go to L1 \n" + 
        "      add  1 6 1  result = result + cand\n" + 
        "      add  3 3  3  iterator = iterator + iterator \n"+
        "      add  6 6  6    cand = cand + cand  \n" + 
        "      beq  2 3  2   if(iterator == sign) go to exit \n"+
        "      beq  0 0  mul   jump to multiplication \n" + 
        "      noop          \n" +
        "      halt  \n"+
        
        "base .fill 4 \n"+
        "exponent .fill 3 \n"+
        "one .fill 1 \n"+
        "neg1 .fill -1 \n" +
        "mcand  .fill 32766 \n" + 
        "mplier .fill 10383\n" +  
        "sign .fill 1073741824 " ;                    
 */


/*
  neg1 = $0
  result / answer = $1
  sign = $2 
  iterator = $3
  return adddress = $4
  temp = $5
  plier = $6
  cand = $7
   */