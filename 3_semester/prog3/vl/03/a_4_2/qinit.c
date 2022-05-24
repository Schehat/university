#include <stdio.h>

void qinit(int arr[], int size)
{
    for (int i = 1; i <= size; i++)
    {
        arr[i - 1] = i * i;
        printf("%d\n", arr[i - 1]);
    }
}