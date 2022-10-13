#include<iostream>


int combination(int n, int r){
    // n! / (n-r)n!
    // std::cout << "n : " << n << "  " ;
    // std::cout << "r : " << r << "\n";
    if(r == 0 || n == r) return 1;
    std::cout << "n : " << n << "  " ;
    std::cout << "r : " << r << "\n";


    return combination(n-1,r)  + combination(n-1,r-1);
}

int main(){
    std::cout << combination(3,0);
    return combination(3,0);    

}
/* assembly 

combination(n,r) 

nCr(4,2)
= nCr(4-1, 2-1) + nCr(4-1, 2)
= nCr(3, 1) + nCr(3, 2)
= nCr(3-1, 1) + nCr(3-1,0) + nCr(3-1, 2-1) + nCr(3-1, 2)
= nCr(2, 1) + nCr(2,0) + nCr(2,1) + nCr(2,2)
= nCr(1, 0) + nCr(1,1) + 1 + nCr(1,0) + nCr(1,1) + 1
= 1 + 1 + 1 + 1 + 1 + 1
= 6










/*Aseembly Combination
"      lw   0 1 n     $1 = 4  \n" +
        "      lw   0 2 r     $2 = 2  \n" +
        "      lw   0 6 end   save end in $6 \n" + 
        "      sw   5 6 stack save end = stack address = 0 \n" +
        "comb  lw   0 6 pos1   $6 = 1\n" + 
        "      add  5 6 5      increment stack pointer\n" +
        "      sw   5 1 stack  store $1 in stack \n" + 
        "      add  5 6 5      increment stack pointer\n" + 
        "      sw   5 2 stack  store $2 in stack \n" + 
        "      beq  2 0 load   if ( r == 0 ) jump to load \n" + 
        "      beq  1 2 load   if ( r == n ) jump to load \n" + 
        "      add  5 6 5      increment stack pointer \n" + 
        "      lw   0 6 neg1   $6 = -1 \n" +
        "      add  1 6 1      n = n + 1 \n " +
        "      lw   0 6 one    $6  = address of one \n" +
        "      sw   5 6 stack  stored address of one in stack \n" + 
        "      beq  0 0 comb   jump to combination \n" + 
        "first lw   0 6 neg1  $6 = -1 \n" +
        "      add  2 6 2       r = r -1 \n" +
        "      lw   0 6 root    $6 = address of root \n" +
        "      sw   5 6 stack   stored address of root in stack\n" + 
        "      beq  0 0 comb    jump to combination \n" +
        "load  lw   0 6 neg1    $6 = -1 \n" + 
        "      lw   5 2 stack   recover $2 from stack\n" +
        "      add  5 6 5       decrement stack pointer \n" +
        "      lw   5 1 stack   recover $1 from stack \n" +
        "      add  5 6 5       decrement stack pointer \n" +
        "      lw   5 4 stack   recover function from stack to $4 \n" +
        "      lw   0 6 pos1    $6 = 1\n" +
        "      add  3 6 3       $3= $3 + 1\n" +
        "      jalr 4 7         jump to address contain in $4 save return address in $7 \n" +
        "plus  lw   0 6 neg1    $6 = -1 \n" +
        "      add  3 6 3       $3 = $3 - 1\n" +
        "      add  5 6 5       decrement stack pointer \n" +
        "      beq  0 0 load    jump to load \n" +  
        "stop   halt end of program \n" + 

         
        "com .fill comb \n"+
        "n   .fill 7 \n"+
        "r   .fill 2 \n"+
        "neg1 .fill -1 \n" + 
        "pos1 .fill  1 \n" +  
        "one  .fill first\n" +
        "road .fill load \n" + 
        "root  .fill plus \n"+ 
        "end .fill stop \n" + 
        "stack .fill 0 \n"; 
    */


/*
    $0     value 0
    $1      n input to function
    $2     r input to function
    $3     return value of function
    $4     local variable for function
    $5     stack pointer
    $6     temporary value (can hold different values at different times, e.g.
            +1, -1, function address)
    $7 return address



*/