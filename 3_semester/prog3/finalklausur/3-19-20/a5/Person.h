#ifndef PERSON_H
#define PERSON_H

#include "Ort.h"
#include <string>
using std::string;

class Person
{
private:
    Ort *geburtsort;
    Ort *wohnort;
    int alter;
    string name;

public:
    Person(Ort *geb, Ort *wohn, int alter, string name);
    virtual ~Person();
    virtual void setAlter(int alter);
    const string getName() const;
};

#endif
