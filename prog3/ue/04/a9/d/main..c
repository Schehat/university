#include <stdio.h>
void main()
{
    char *s = "Hallo";
    char *p = s;
    printf("%c %c", *(p + 3), s[1]);
}