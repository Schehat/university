#include "punkt.h"

point erzeuge(int x, int y)
{
    point p = {x, y};
    return p;
}

void spiegeln(point *p)
{
    p->x *= -1;
}