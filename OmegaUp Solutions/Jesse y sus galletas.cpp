#include <bits/stdc++.h>
typedef long long ll;
using namespace std;


ll cookies(ll k, vector<ll> A) {
    //Este es mi minHeap
    ll counterStep = 0;
    priority_queue <ll, vector<ll>, greater<ll> > minhp;
    for(ll temp:A){
        minhp.push(temp);
    }
    while (!minhp.empty()){
        if(minhp.top()<k){
            ll min1=minhp.top();
            minhp.pop();
            if(!minhp.empty()){
                ll min2=minhp.top();
                minhp.pop();
                ll newCookie=min1+2*min2;
                minhp.push(newCookie);
                counterStep++;
            }else{
                return -1LL;
            }
        }else{
            return counterStep;
        }
    }
    return -1LL;
}

int main() {
    ll N, K;
    scanf("%lld %lld", &N,&K);
    vector<ll> galletas;
    for(ll i = 0; i<N; i++){
        ll temp;
        scanf("%lld",&temp);
        galletas.push_back(temp);
    }
    printf("%lld",cookies(K,galletas));

}
