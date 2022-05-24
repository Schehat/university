#include <stdio.h>

void mystrcat(char s1[], char s2[])
{
    int zerobyte_index_s1 = 0;
    while (s1[zerobyte_index_s1] != '\0')
    {
        zerobyte_index_s1++;
    }

    int zerobyte_index_s2 = 0;
    while (s2[zerobyte_index_s2] != '\0')
    {
        zerobyte_index_s2++;
    }

    for (int i = 0; i < zerobyte_index_s2; i++)
    {
        s1[zerobyte_index_s1 + i] = s2[i];
    }
    s1[zerobyte_index_s1 + zerobyte_index_s2] = '\0';
}