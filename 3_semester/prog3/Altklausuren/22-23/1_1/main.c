#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int starts_with(char *str, char *anfang)
{ // gibt erstes vorkommen
    return strncmp(str, anfang, strlen(anfang)) == 0;
}

void finde_teil_string(char *text, char *suchString, char **first, char **last)
{
    int lenText = 0;
    char *ptr = text;
    while (*ptr != '\0')
    {
        ptr++;
        lenText++;
    }

    int lenSuchString = 0;
    ptr = suchString;
    while (*ptr != '\0')
    {
        ptr++;
        lenSuchString++;
    }

    int i;
    for (i = 0; i < lenText; i++)
    {
        if (starts_with(text + i, suchString))
        {
            *first = text + i;
            break;
        }
    }

    for (; i < lenText; i++)
    {
        if (starts_with(text + i, suchString))
            *last = text + i;
    }
}

int main(void)
{
    char *first;
    char *last;

    finde_teil_string("elhileuxhikaskshix", "hi", &first, &last);

    printf("%s %s", first, last);
}
