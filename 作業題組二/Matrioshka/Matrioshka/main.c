//
//  main.c
//  Matrioshka
//
//  Created by 黄涛 on 15/10/5.
//  Copyright © 2015年 tobb. All rights reserved.
//

#include <stdio.h>
#include <string.h>

int per[10000];
char end;
int num;

int count(int head, int tail) ;
int find(int m, int head, int tail);

int main(int argc, const char * argv[]) {
    
    while(scanf("%d%c",&per[0],&end)!=EOF){
        num=1;
        if(end!='\n'){
            while(scanf("%d%c",&per[num],&end)&&end!='\n')
                num++;
        }
        
        
        if (-per[0] !=per[num]) {
            printf(":-( Try again.\n");
            continue;
        }
        
        int count1 = count(0, num);
        if (count1 == -1) {
            printf(":-( Try again.\n");
        } else {
            printf(":-) Matrioshka!\n");
        }
        
    }
    
    return 0;
}

int count(int head, int tail) {
    
    int i = head + 1;
    int count1 = 0;
    
    while (i < tail) {
        int j = find(-per[i], i + 1, tail);
        if (j == -1)
            return -1;
        
        if (j - i == 1) {
            count1 += per[j];
        } else {
            int tmp = count(i, j);
            if (tmp == -1)
                return -1;
            else
                count1 += tmp;
        }
        
        i = j + 1;
        
    }
    
    if (count1 < -per[head])
        return -per[head];
    else
        return -1;
    
}

int find(int m, int head, int tail) {
    int n = 1;
    for (int i = head; i < tail; i++) {
        if (per[i] == m) {
            n--;
            if (n == 0) {
                return i;
            }
        } else if (-per[i] == m) {
            n++;
        }
    }
    return -1;
}

