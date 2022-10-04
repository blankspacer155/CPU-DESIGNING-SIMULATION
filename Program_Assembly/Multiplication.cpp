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
"            lw          0           2            sign       $2 = -2147483648  \n" + //0
"            lw          0           6            input      $6 = memory[input1]       \n" + //1
"            lw          0           7           input      $17 = memory[input1]       \n" + //1
"            lw          0           5            multiplication     prepare to call sub4n. $2=sub4n\n" + //2
"            jalr        5           4                       call multiplication; $4=return address; $3=answer\n" + //3
"            halt\n" + // 8
"mul      
"            nand       6           3           8           (plier nand iterator) = temp \n" + // 11
"            nand       8           8           8           (temp nand temp) = temp \n" + // 11
"            beq        8           0           2          if(temp == zero)  \n" + // 11
"            add        1           1           1           result = result + result\n" + //12
"            add 	     	3		      	9		       	3        			iterator = iterator + iterator
"            add        7           7          7           cand = cand + cand  \n" + // 16
"			       beq 		    2           3           2
"			       beq 		    0           0           mul
"            jalr         4           1                     
"increment       .fill         1\n" + // 21
"Multiplicaiton   .fill        mul                            contains the address of sub4n\n" + // 23
"Cand      .fill         2                                  input = 10\n" + // 24
"plier      .fill         8                                  input = 8\n" + // 24
"stack .fill    0                      beginning of stack (value is irrelevant)"; // 25
"sign 		.fill        -2147483648                               
 อาจจะลดตัวแปรได้
 */


/*
  result / answer = $1
  iterator = $3
  return adddress = $4
  multiplication = $5
  increment = $6
  plier = $6
  cand = $7
  temp = $8 
  อาจจะลดตัวแปรได้ลองเขียนให้ได้ก่อน T_T
   */