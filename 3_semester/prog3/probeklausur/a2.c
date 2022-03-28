#include <stdio.h>

int char2int(char c)
{
    return c - '0';
}

void foo(char *const p, int *querSumme)
{
    int x = char2int(*p);
    *querSumme += x;
}

int main(void)
{
    char zahl[] = "3254712874217846";
    int querSumme = 0;
    char *cursor = zahl;
    while (*cursor != '\0')
    {
        foo(cursor, &querSumme);
        ++cursor;
    }
    printf("%d", querSumme);
}