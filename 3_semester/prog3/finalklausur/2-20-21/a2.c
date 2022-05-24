#include <stdio.h>

int char2Int(char c)
{
    return c - '0';
}

void foo(char **cursor, int *quersumme)
{
    *quersumme += char2Int(**cursor);
    ++*cursor;
}

int main(void)
{
    char string[] = "579";
    int quersumme = 0;
    char *cursor = string;

    while (*cursor != '\0')
    {
        foo(&cursor, &quersumme);
    }
    printf("%d", quersumme);
}