#include <stdio.h>

int main(void)
{
    int arr[100];

    for (int i = 1; i <= 100; i++)
    {
        arr[i - 1] = i * i;
        printf("%d\n", arr[i - 1]);
    }

    return 0;
}