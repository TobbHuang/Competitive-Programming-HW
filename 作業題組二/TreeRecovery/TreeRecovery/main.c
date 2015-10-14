//
//  main.c
//  TreeRecovery
//
//  Created by 黄涛 on 15/10/4.
//  Copyright © 2015年 tobb. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char str1[1000000];
char str2[1000000];

typedef struct node{
    char m;
    struct node *leftNode;
    struct node *rightNode;
} *treeNode;

treeNode findNode(int preLeft, int preRight, int middleLeft,
                  int middleRight) {
    
    if (preLeft > preRight) {
        return NULL;
    }
    
    char m = str1[preLeft];
    treeNode node=(treeNode)malloc(sizeof(struct node));
    node->m = m;
    if (preLeft == preRight) {
        node->leftNode = NULL;
        node->rightNode = NULL;
        return node;
    }
    
    int index;
    for (index = middleLeft; index <= middleRight; index++) {
        if (m == str2[index]) {
            break;
        }
    }
    node->leftNode = findNode(preLeft + 1, preLeft + index - middleLeft,
                              middleLeft, index - 1);
    node->rightNode = findNode(preLeft + index - middleLeft + 1, preRight,
                               index + 1, middleRight);
    
    return node;
    
}

void print(treeNode node) {
    if (node != NULL) {
        print(node->leftNode);
        print(node->rightNode);
        printf("%c",node->m);
    }
}

int main(int argc, const char * argv[]) {
    while(scanf("%s %s",str1,str2)!=EOF){
        treeNode node=findNode(0, (int)strlen(str1)-1, 0, (int)strlen(str2)-1);
        print(node);
        printf("\n");
    }
    return 0;
}
