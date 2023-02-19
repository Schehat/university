#ifndef BUCH_H
#def BUCH_H
#include <string>
#include <Person.h>

using std::string;

class Buch
{
public:
    Buch(Person *autor, const string &titel);
    virtual ~Buch();
    virtual string getTitel();

private:
    Person *autor;
    const string titel;
};
#endif