#include "Buch.h"

Buch::Buch(Person *autor, const string &titel) : autor{autor}, titel{titel} {}
Buch::~Buch() {}
string Buch::getTitel()
{
    return titel;
}