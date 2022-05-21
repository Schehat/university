#include "Person.h"
#include "Ort.h"

Person::Person(Ort *geburtsort, Ort *wohnort, int alter, string name) : geburtsort{new Ort{*geburtsort}},
                                                                        wohnort{new Ort{*wohnort}}, alter{alter}, name{name} {}

Person::~Person()
{
    delete geburtsort;
    delete wohnort;
}

void Person::setAlter(int alter)
{
    this->alter = alter;
}

const string Person::getName() const
{
    return name;
}