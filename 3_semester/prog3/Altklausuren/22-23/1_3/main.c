#include <stdio.h>
#include "buch.h"
int main(void)
{
    buch b = erzeuge(99);
    ausleihen(&b);
    printf("Buchnummer: %d\n", b.nr);
    if (b.ausgeliehen == 1)
    {
        printf("Buch %d wurde ausgeliehen", b.nr);
    }
    return 0;
}
