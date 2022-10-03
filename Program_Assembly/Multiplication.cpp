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

		iterator = iterator + iterator;
		cand += cand;
	}while(iterator != 0 );

	return result;

}

int main(){
    std::cout <<  multiplication(32766,10383);
}




/*Aseembly Multiplication
"            lw          0           2         sign       $2 = 32  \n" + //0
"            lw          0           12         neg1       $12 = -1  \n" + //0
"            lw          0           6           pos1       $6 = 1  \n" + //0
"            lw          0           9          input      $9 = memory[input1]       \n" + //1
"            lw          0           10           input      $10 = memory[input1]       \n" + //1
"            lw          0           5           multiplication     prepare to call sub4n. $2=sub4n\n" + //2
"            jalr        5           4                       call multiplication; $4=return address; $3=answer\n" + //3
"            halt\n" + // 8
"mul         sw         7           4           stack       save return address on stack\n" + 
"            add        7           6           7           increment stack pointer\n" + 
"            sw         7           2           stack       save $2 = n on stack\n" + 
"            add        7           6           7           increment stack pointer\n" + //12
"            sw         7           3           stack       save $3 = iterator on stack\n" + 
"            add        7           6           7           increment stack pointer\n" + //12
"            sw         7           9           stack       save $9 = temp on stack\n" + // 11
"            lw         0           3           pos1         iterator = 1\n " +
"            nand        10         3           8           (plier nand iterator) = temp \n" + // 11
"            nand        8          8            8           (temp nand temp) = temp \n" + // 11
"            beq        8          zero          2          if(temp == zero)  \n" + // 11
"            add        3           3           3           result = result + result\n" + //12
"            add 		3			3			3			iterator = iterator + iterator
"            add        9           9           9           cand = cand + cand  \n" + // 16
"			nand 		10  		10     		8          plier nand plier \n"+
"  			 add 		8			6           8"			2'complement bit \n"+
"            add 		8			6           8			2'plier + 1;
"			 beq 		"
"            jalr         4           2                     
"increment       .fill         1\n" + // 21
"zero       .fill         0\n" + // 21
"neg1       .fill         -1\n" + // 22
"Multiplicaiton   .fill        mul                            contains the address of sub4n\n" + // 23
"Cand      .fill         2                                  input = 10\n" + // 24
"plier      .fill         8                                  input = 8\n" + // 24
"stack .fill    0                      beginning of stack (value is irrelevant)"; // 25
"sign 		.fill        32                               
 อาจจะลดตัวแปรได้
 */


/*
  result / answer = $1
  n = $2
  iterator = $3
  return adddress = $4
  multiplication = $5
  increment = $6
  stack = $7
  temp = $8
  cand = $9
  plier = $10
  decrement = $11
  neg = $12
  อาจจะลดตัวแปรได้ลองเขียนให้ได้ก่อน T_T
   */