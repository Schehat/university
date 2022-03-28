#include <stdio.h>
#include <stdlib.h>
int main(void)
{

    int i = 5;
    int *p = (int *)malloc(sizeof(int));

    printf("int: %p\n", (void *)&i);
    printf("addr: %p\n", (void *)&p);
}
