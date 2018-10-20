
#include <bits/stdc++.h>
typedef long long ll;
using namespace std;

int main() {
    ll n,m,k;
    priority_queue<ll> colaImpresion;
    queue<ll> impresiones;
    unordered_multiset<ll> conteo;
    ll tiempo = 0;
    ll miImpresion=0;
    scanf("%lld %lld %lld",&n,&m,&k);
    for(ll i = 0; i <n; i++){
        ll temp;
        scanf("%lld", &temp);
        if(i+1<m){
            conteo.insert(temp);
        }

        if (i+1==m) miImpresion=temp;
        colaImpresion.push(temp);
        impresiones.push(temp);

    }

    ll veces = conteo.count(miImpresion);

    while(!impresiones.empty()){
        ll impresion = impresiones.front();
        if(impresion==colaImpresion.top()){
            tiempo+=2;
            impresiones.pop();
            colaImpresion.pop();

            if (impresion==miImpresion ){
                if (veces ==0)break;
                veces--;
            }
        }else{
            tiempo +=2;
            impresiones.pop();
            impresiones.push(impresion);
        }
    }
    printf("%lld" , tiempo);
}
