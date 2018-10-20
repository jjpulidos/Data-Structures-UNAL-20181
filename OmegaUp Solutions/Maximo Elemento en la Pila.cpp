#include <bits/stdc++.h>

using namespace std;

typedef long long ll;


int main()
{
    ll n;
    stack<ll> pila;
    stack<ll> pilaMayor;
    scanf("%lld",&n);
    while(n--){
        ll oper;
        scanf ("%lld",&oper);
        if (oper==1){
            ll x;
            scanf ("%lld",&x);
            pila.push(x);
            if(!pilaMayor.empty()){
                if(pilaMayor.top()<=x){
                    pilaMayor.push(x);
                }
            }else{
                pilaMayor.push(x);
            }
        }else if(oper==2){
            if (!pila.empty()){
                if(!pilaMayor.empty()){
                    if(pilaMayor.top()==pila.top()){
                        pilaMayor.pop();
                    }
                }
               pila.pop();
            }

        }else if(oper ==3){
            if(!pilaMayor.empty()){
                printf("%lld\n", pilaMayor.top());
            }

        }

    }
    return 0;
}