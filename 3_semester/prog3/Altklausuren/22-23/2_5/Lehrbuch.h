#ifndef LEHRBUCH_H
#def LEHRBUCH_H
#include <string>
#include <Person.h>

class Lehrbuch : public Buch
{
public:
    Lehrbuch(Person *autor, const string &titel);
    virtual string getTitel() override;
};
#endif