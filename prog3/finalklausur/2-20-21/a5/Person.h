#ifndef PERSON_H
#define PERSON_H

#include <string>
using std::string;

class Person
{
public:
    Person(int alter, string name, string *wohnort, string *gebort);
    virtual void setAlter(int alter);
    const string getName() const;
    virtual ~Person();

    // private:
    int alter;
    string name;
    string *wohnort; // statt Ort Klasse, string. Sollte keinen Unterschied machen, da mit mit Zeigern gearbeitet wird
    string *gebort;
};
#endif