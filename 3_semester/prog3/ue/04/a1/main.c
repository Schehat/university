#include <stdio.h>
#include <string.h>

struct beispiel
{
    short i;
    int j;
    char s[10];
};

void fill(char u[])
{
    *(short *)u = 89;
    u += sizeof(short) + 2;
    *(int *)u = 32168;
    u += sizeof(int);
    strcpy((char *)u, "Rosi");
}

int main(void)
{
    struct beispiel bsp;

    /* Die Struktur wird in ein Char-Array umgewandelt
       und der fill-Funktion uebergeben. */
    fill((char *)&bsp);
    printf("%d %d %s\n", bsp.i, bsp.j, bsp.s);
    return 0;
}
