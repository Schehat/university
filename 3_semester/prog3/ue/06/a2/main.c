#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

int checkError(char *endptr, char *input)
{
    if (strlen(endptr) != 0)
    {
        /* Da ist noch ein unverarbeiteter Rest */
        printf("Kann '%s' nicht in Zahl umwandeln: Falsches Format\n", input);
        return 1;
    }
    else if (errno != 0)
    {
        printf("Kann '%s' nicht in Zahl umwandeln: %s\n", input, strerror(errno));
        return 1;
    }
    return 0;
}

int main(int argc, char *argv[])
{
    int a, b;
    errno = 0;
    char *endptr = NULL;

    if (argc != 3)
    {
        printf("Benutzung: %s <zahl> <zahl>", argv[0]);
        return 1;
    }

    a = strtol(argv[1], &endptr, 10);
    if (checkError(endptr, argv[1]) == 1)
    {
        return 1;
    }

    b = strtol(argv[2], &endptr, 10);
    if (checkError(endptr, argv[2]) == 1)
    {
        return 1;
    }

    printf("%d + %d = %d", a, b, a + b);
}