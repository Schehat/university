#include "buch.h"
buch erzeuge(int nr)
{
    buch b = {99, 0};
    return b;
}

void ausleihen(buch *v)
{
    v->ausgeliehen = 1;
}