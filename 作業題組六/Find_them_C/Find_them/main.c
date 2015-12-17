#include <stdio.h>
#include <string.h>

int find(int x, int* same);
void merge(int x, int y, int* same);

int main(int argc, const char * argv[]) {
    int numOfCase;
    scanf("%d",&numOfCase);
    while (numOfCase-- > 0) {
        
        int n,m;
        scanf("%d%d",&n,&m);
        int same[2*n+1];
        int i;
        for(i=0;i<2*n+1;i++){
            same[i]=-1;
        }
        
        char cmd;
        int a,b;
        while(m-->0){
            scanf(" %c%d%d",&cmd,&a,&b);
            
            if (cmd=='D') {
                merge(a, b + n, same);
                merge(a + n, b, same);
            } else {
                if (find(a, same) == find(b, same)
                    || find(a + n, same) == find(b + n, same)) {
                    printf("In the same gang.\n");
                } else if (find(a + n, same) == find(b, same)
                           || find(a, same) == find(b + n, same)) {
                    printf("In different gangs.\n");
                } else {
                    printf("Not sure yet.\n");
                }
            }
            
        }
        
    }
    
    return 0;
}

int find(int x, int* same) {
    return (same[x] == -1 ? x : (same[x] = find(same[x], same)));
}

void merge(int x, int y, int* same) {
    if (find(y, same) != find(x, same)) {
        same[find(y, same)] = find(x, same);
    }
}
