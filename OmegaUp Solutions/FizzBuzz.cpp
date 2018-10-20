#include <bits/stdc++.h>

using namespace std;
#define EPS 0.0000001

int main()
{

    for (int i = 1;i<1001;i++){

        if((((((double)i/3))-(i/3)<EPS)&&(((double)i/5))-(i/5)<EPS)){
            puts("FizzBuzz");
        }else if ((((double)i/3))-(i/3)<EPS){
            puts("Fizz");
        }else if ((((double)i/5))-(i/5)<EPS){
            puts("Buzz");
        }else{
            printf("%d\n", i);
        }
    }

    return 0;
}
