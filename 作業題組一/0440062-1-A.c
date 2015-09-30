//
//  main.c
//  Amalgamated_Artichokes
//
//  Created by 黄涛 on 15/9/17.
//  Copyright (c) 2015年 tobb. All rights reserved.
//

#include <stdio.h>
#include <math.h>

int p,a,b,c,d,k;

double calculate(int k);

int main(int argc, const char * argv[]) {
    
    while(scanf("%d %d %d %d %d %d",&p,&a,&b,&c,&d,&k)!=EOF){
        double maxDecline = 0, max = -10000;
        
        int i;
        for (i = 1; i <= k; i++) {
            double m = calculate(i);
            if (m > max)
                max = m;
            else {
                double tmp = max - m;
                if (tmp > maxDecline)
                    maxDecline = tmp;
            }
        }
        
        printf("%.7lf\n",maxDecline);
        
    }
    
    
    return 0;
}

double calculate(int k) {
    return p * (sin(a * k + b) + cos(c * k + d) + 2);
}
