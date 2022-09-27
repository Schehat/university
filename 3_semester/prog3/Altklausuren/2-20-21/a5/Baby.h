#ifndef BABY_H
#define BABY_H

#include "Person.h"
#include <string>

using std::string;

class Baby : public Person
{
public:
    virtual void setAlter(int alter) override;
    Baby(string name, string *wohnort, string *gebort);
};
#endif