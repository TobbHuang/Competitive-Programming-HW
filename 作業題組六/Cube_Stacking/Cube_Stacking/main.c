#include <stdio.h>

#define N 30000

typedef struct cube{
    int bottom;
    int count;
    int sizeOfStack;
}cube;

void Move(int x,int y);
int Clear(int x);

cube node[N];

int main(int argc, const char * argv[]) {
    
    int i;
    for(i=0;i<N;i++){
        node[i].bottom=i;
        node[i].count=0;
        node[i].sizeOfStack=1;
    }
    
    int p;
    scanf("%d",&p);
    
    while(p-->0){
        char cmd;
        int x,y;
        scanf("\n%c",&cmd);
        
        if(cmd=='M'){
            scanf("%d%d",&x,&y);
            x--;
            y--;
            Move(x,y);
        } else{
            scanf("%d",&x);
            x--;
            printf("%d\n",Clear(x));
        }
        
    }
    
    return 0;
}

void Move(int x,int y){
    Clear(x);
    Clear(y);
    int bottomx=node[x].bottom,bottomy=node[y].bottom;
    node[bottomx].bottom=bottomy;
    node[bottomx].count+=node[bottomy].sizeOfStack;
    node[bottomy].sizeOfStack+=node[bottomx].sizeOfStack;
}

int Clear(int x){
    if(node[x].count!=0){
        node[x].count+=Clear(node[x].bottom);
        node[x].bottom=node[node[x].bottom].bottom;
        return node[x].count;
    }
    return 0;
}
