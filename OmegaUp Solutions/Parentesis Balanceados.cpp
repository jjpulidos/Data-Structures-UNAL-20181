
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int cas;
    scanf("%d",&cas);
    while(cas--){
        bool flag = false;
        string cadena;
        stack<char> pila;
        cin>>cadena;
        for (int i = 0; i< cadena.length();i++){
            if (pila.empty()){
                pila.push(cadena[i]);
            }else{
                if(pila.top()=='{'&&cadena[i]=='}'){
                    pila.pop();
                }else if (pila.top()=='['&&cadena[i]==']'){
                    pila.pop();
                }else if(pila.top()=='('&&cadena[i]==')'){
                    pila.pop();
                }else{
                    pila.push(cadena[i]);
                }
            }

        }

        if (!pila.empty()){
            cout<<"NO"<<endl;
        }else{
            cout<<"SI"<<endl;
        }

    }

    return 0;
}
