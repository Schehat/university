#include <stdio.h>
#include "punkt.h"

int main()
{
    point p = erzeuge(5, 2);
    spiegeln(&p);
    printf("(%d,%d)", p.x, p.y); // soll (-5,2) sein
    return 0;
}