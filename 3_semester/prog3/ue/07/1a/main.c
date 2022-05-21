#include <stdio.h>

void print1(void)
{
    printf("Hallo\n");
}

void print2(int i)
{
    printf("%d\n", i);
}

void times1(int n, void (*func)(void))
{
    for (int i = 0; i < n; i++)
    {
        (*func)();
    }
}

void times2(int n, void (*func)(int))
{
    for (int i = 0; i < n; i++)
    {
        (*func)(i);
    }
}

int main(void)
{
    times1(3, print1);
    times2(4, print2);
}