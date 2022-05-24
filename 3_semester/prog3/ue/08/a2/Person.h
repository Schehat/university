#ifndef PERSON_H
#define PERSON_H
#include <string>
using std::string;
class Person
{
public:
    Person();
    Person(string name, int geburtsjahr);
    void print() const;

private:
    string name;
    int geburtsjahr;
};
#endif