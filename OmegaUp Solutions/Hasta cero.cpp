#include <bits/stdc++.h>
#define MAX 1000001

using namespace std;
int todosNumeros[MAX];

int main()
{

    memset(todosNumeros,-1,sizeof(todosNumeros));
    for(int a=0; a<4;a++)todosNumeros[a]=a;

    for (int a=0;a<MAX;a++){
        if(todosNumeros[a]==-1||todosNumeros[a]>(todosNumeros[a-1]+1)){
            todosNumeros[a]=todosNumeros[a-1]+1;
        }
        for(int b=1;( b<=a) && (b*a<MAX); b++){
            if((todosNumeros[b*a]==-1) || ((todosNumeros[a]+1)<todosNumeros[b*a]))
                todosNumeros[b*a] = todosNumeros[a]+1;
        }
    }

    int Q;
    scanf("%d",&Q);
    while(Q--){
        int N;
        scanf("%d",&N);
        printf("%d\n",todosNumeros[N]);
    }


    return 0;
}
