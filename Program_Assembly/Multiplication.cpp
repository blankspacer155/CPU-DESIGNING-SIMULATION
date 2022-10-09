#include<iostream>
#include<bitset>


// Type your code here, or load an example.
int multiplication (int cand,int plier){
	int iterator =  0b1; // reg
	int result = 0;
	// if (cand > 65536 || plier > 65536) return -1;
	do {
		
		if((plier & iterator) == 0){
		    
		}else{
			result = result + cand;
		}
    std::cout << iterator << "\n";
		iterator = iterator + iterator;
		cand += cand;
	}while(iterator != 0 );

	return result;

}

int main(){
    std::cout <<  multiplication(32766,10383);
}




/*Aseembly Multiplication
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
        "one .fill 1 \n"+
        "mcand  .fill 32766 \n" + 
        "mplier .fill 10383\n" +  
        "sign .fill 1073741824 " ;                    
 */


/*
  zero = $0
  result / answer = $1
  sign = $2 
  iterator = $3
  return adddress = $4
  temp = $5
  plier = $6
  cand = $7
   */