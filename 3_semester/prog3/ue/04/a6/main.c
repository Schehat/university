#include <stdio.h>

char *find(char s[], char c)
{
    char *ptr = NULL;
    for (int i = 0; s[i] != '\0'; i++)
    {
        if (s[i] == c)
        {
            ptr = &s[i];
        }
    }
    return ptr;
}

int main(void)
{
    char *a = find("hallo", 'b');
    printf("%p \n", a);
    if (a == NULL)
    {
        return 1;
    }
    else
    {
        printf("%c", *a);
    }
    return 0;
}