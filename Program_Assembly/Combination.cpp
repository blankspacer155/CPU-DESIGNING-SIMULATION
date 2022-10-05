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
    
    return combination(3,2);    

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

*/