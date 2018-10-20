#include <bits/stdc++.h>

using namespace std;


void print(unsigned short N,int* recorrido) {
    cout << endl;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cout << recorrido[(i*N) + j ] << " ";
        }
        cout << endl;
    }
}

int main() {

   
    unsigned short int N, a, b, c, d;
    scanf("%hu", &N);
    int recorrido[N][N];
    memset(recorrido, false, sizeof(recorrido));
    for (int i = 0; i < N; i++) {
        char linea[N];
        scanf("%s", linea);
        for (int j = 0; j < N; j++) {
            recorrido[i][j] = (linea[j] == '.') ? 0 : -1;
        }
    }

    queue<pair<int, int>> colaTriangulos;
    scanf("%hu %hu %hu %hu", &a, &b, &c, &d);
    recorrido[c][d] = -9;

    int posinY=a;
    int posinX=b;

    while(!colaTriangulos.empty()) {
        a=colaTriangulos.front().first;
        b=colaTriangulos.front().second;


        for (int i = b + 1; i != N; i++) {
            if (recorrido[a][i] != -1) {
                if (recorrido[a][i] != 0 && recorrido[a][i] > recorrido[a][b] + 1) {
                    recorrido[a][i] = recorrido[a][b] + 1;

                } else if (a == posinY && i == posinX) {
                } else if (recorrido[a][i] == 0) {
                    recorrido[a][i] = recorrido[a][b] + 1;
                    colaTriangulos.push(make_pair(a, i));
                }else if(recorrido[a][i] == -9){
                    recorrido[a][i] = recorrido[a][b] + 1;
                }
            } else {
                break;
            }

        }
        for (int i = b - 1; i != -1; i--) {

            if (recorrido[a][i] != -1) {
                if (recorrido[a][i] != 0 && recorrido[a][i] > recorrido[a][b] + 1) {
                    recorrido[a][i] = recorrido[a][b] + 1;
                } else if (a == posinY && i == posinX) {
                } else if (recorrido[a][i] == 0) {
                    recorrido[a][i] = recorrido[a][b] + 1;
                    colaTriangulos.push(make_pair(a, i));
                }else if(recorrido[a][i] == -9){
                    recorrido[a][i] = recorrido[a][b] + 1;
                }
            } else {
                break;
            }
        }
        for (int j = a + 1; j != N; j++) {
            if (recorrido[j][b] != -1) {
                if ((recorrido[j][b] != 0 && recorrido[j][b] > recorrido[a][b] + 1)) {
                    recorrido[j][b] = recorrido[j][b] + 1;

                } else if (j == posinY && b == posinX) {
                } else if (recorrido[j][b] == 0||recorrido[j][b] == -9) {
                    recorrido[j][b] = recorrido[a][b] + 1;
                    colaTriangulos.push(make_pair(j, b));
                }else if(recorrido[j][b] == -9){
                    recorrido[j][b] = recorrido[a][b] + 1;
                }
            } else {
                break;
            }

        }

        for (int j = a - 1; j != -1; j--) {

            if (recorrido[j][b] != -1) {
                if ((recorrido[j][b] != 0 && recorrido[j][b] > recorrido[a][b] + 1)) {
                    recorrido[j][b] = recorrido[j][b] + 1;

                } else if (j == posinY && b == posinX) {
                } else if (recorrido[j][b] == 0) {
                    recorrido[j][b] = recorrido[a][b] + 1;
                    colaTriangulos.push(make_pair(j, b));
                }else if(recorrido[j][b] == -9){
                    recorrido[j][b] = recorrido[a][b] + 1;
                }
            } else {
                break;
            }
        }

        colaTriangulos.pop();
    }
    printf("%d",recorrido[c][d]);
        return 0;
}
