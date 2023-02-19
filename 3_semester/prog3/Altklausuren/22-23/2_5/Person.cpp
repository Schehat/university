#include "Person.h"
#include <string>

using std::string;

Person::Person(int alter, string name, string *wohnort, string *gebort) : alter{alter}, name{name}
{
    this->wohnort = new string{*wohnort};
    this->gebort = new string{*gebort};
}

void Person::setAlter(int alter) { this->alter = alter; }
const string Person::getName() const { return name; }
Person::~Person()
{
    delete wohnort; // komisch, bei delete[] segmentation core dumped
    delete gebort;
    // name delete nicht notwendig, wird implizit
}