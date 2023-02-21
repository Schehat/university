#include "Lehrbuch.h"
#include "Buch.h"

Lehrbuch::Lehrbuch(Person *person, const string &titel) : Buch{person, titel}
{
}

string Lehrbuch::getTitel()
{
    return Buch::getTitel() + " Lehrbuch";
}