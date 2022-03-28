#include "Baby.h"
#include <iostream>

Baby::Baby(Ort *geburtsort, Ort *wohnort, std::string name) : Person{geburtsort, wohnort, 0, name} {}
void Baby::setAlter(int alter)
{
    if (alter != 0)
        throw std::invalid_argument("throwing ...");
    Person::setAlter(alter);
}