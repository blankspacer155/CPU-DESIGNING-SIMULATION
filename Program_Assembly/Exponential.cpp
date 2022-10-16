/*Aseembly Exponential
        "       lw 0 6 base \n" +
        "       lw 0 7 exponent \n" +
        "       lw 0 2 sign \n" +
        "       lw 0 4 one temp1 = 1 \n" +
        "       beq 0 7 dog if(exponent == 0) base ^ 0 \n" +
        "       beq 7 4 cat if(exponent == 1) base ^ 1 \n" +
        "       lw 0 5 base temp2 = base \n" +
        "expo   beq 7 4 done if(exponent == 1) end program \n" +
        "       lw 0 4 neg1 temp1 = -1 \n" +
        "       add 7 4 7 exponent = exponent - 1 \n" +
        "       lw 0 4 one temp1 = 1 \n" +
        "       lw   0 3 one iterator = 1 \n" +
        "       lw   0 6 base   reset base  \n" + 
        "mul    nand 5  3  5 (plier nand iterator) = temp2 \n" + 
        "       nand 5 5  5  (temp nand temp) = temp2 \n" + 
        "       beq  0 5 2  if(temp == zero) go to L1 \n" + 
        "       add  1 6 1  result = result + cand\n" + 
        "       add  3 3  3  iterator = iterator + iterator \n"+
        "       add  6 6  6    cand = cand + cand  \n" + 
        "       beq  2 3  2   if(iterator == sign) go to exit \n"+
        "       beq  0 0  mul   jump to multiplication \n" +
        "       lw 0 5 zero \n" +
        "       add 5 0 1 \n" + 
        "       beq 0 0 expo jump to Exponention \n" +
        "cat    lw 0 1 base answer = base \n" +
        "       beq 0 0 done \n" +
        "dog  lw 0 1 one set answer = 1 \n" +
        "done   halt  \n"+
        "base .fill 4 \n"+
        "exponent .fill 3 \n"+
        "zero .fill 0 \n" +
        "one .fill 1 \n"+
        "neg1 .fill -1 \n" +
        "sign .fill 1073741824 \n" ;                    
 */


/*
  zero = $0
  result / answer = $1
  sign = $2 
  iterator = $3
  temp1 = $4
  temp2 = $5
  base = $6
  exponent = $7
   */