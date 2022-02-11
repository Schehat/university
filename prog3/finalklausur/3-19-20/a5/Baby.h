#ifndef BABY_H
#define BABY_H

#include "Person.h"
#include <stdexcept>

class Baby : public Person
{
public:
    Baby(Ort *geburtsort, Ort *wohnort, string name);
    virtual void setAlter(int) override;
};

#endif