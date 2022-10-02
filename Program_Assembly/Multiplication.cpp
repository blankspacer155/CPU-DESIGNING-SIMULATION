#include<iostream>
#include<bitset>


// Type your code here, or load an example.
int multiplication (int cand,int plier){
	int iterator =  0b1; // reg
	int And_temp = 0;
	int ans = cand;
	int result = 0;
	while(iterator >= 0) {
		And_temp = plier & iterator;
		
		if((And_temp & iterator) == iterator){
		    result = result + ans;
		}
		iterator = iterator + iterator;
		ans += ans;
		
	}
	return result;

}

int main(){
    std::cout <<  multiplication(32766,10383);
}