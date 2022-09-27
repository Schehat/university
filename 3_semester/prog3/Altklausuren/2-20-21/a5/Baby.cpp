#include "Baby.h"

#include <string>
#include <iostream>
using namespace std;

Baby::Baby(string name, string *wohnort, string *gebort) : Person::Person{0, name, wohnort, gebort} {}

void Baby::setAlter(int alter)
{
    if (alter != 0)
    {
        cout << "throwing exception 0-0";
    }
    Person::setAlter(alter);
}