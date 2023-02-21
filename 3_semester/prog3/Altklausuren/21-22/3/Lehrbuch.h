#ifndef LEHRBUCH_H
#define LEHRBUCH_H
#include <string>
#include "Buch.h"
#include "Person.h"

using std::string;

class Lehrbuch : public Buch
{
public:
    Lehrbuch(Person *autor, const string &titel);
    virtual string getTitel() override;
};
#endif