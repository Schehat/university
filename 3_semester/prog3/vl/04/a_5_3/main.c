#include <stdio.h>

int main(void)
{
    int zahlen[] = {1, 2, 3, 4, 5, 6};
    int *ipt;
    int i, j;

    for (i = 0; i < 6; i++)
    {
        if (zahlen[i] == 3)
        {
            ipt = &zahlen[i];
        }
    }

    *ipt = -3;

    for (j = 0; j < 6; j++)
    {
        printf("%d ", zahlen[j]);
    }
}