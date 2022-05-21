#include <stdio.h>
#include <stdlib.h>
#define LEN 5

int main(void)
{
    int a[] = {1,
               2,
               3,
               4,
               5};

    int *b;
    b = (int *)malloc(LEN * sizeof(int));
    // or int b[LEN]

    for (int i = 0; i < LEN; i++)
    {
        *(b + i) = *(a + 5 - 1 - i);
    }

    for (int i = 0; i < LEN; i++)
    {
        printf("%d\n", *(b + i));
    }

    // int b[LEN];

    // int *ptr = b;

    // int i = 1;
    // while (i <= LEN)
    // {
    //     *ptr = *(a + LEN - i);
    //     ++ptr;
    //     ++i;
    // }

    // for (int i = 0; i < LEN; i++)
    // {
    //     printf("%d", b[i]);
    // }
}