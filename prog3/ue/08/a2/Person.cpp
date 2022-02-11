#include <iostream>
#include <string>
#include "Person.h"

Person::Person() : name{}, geburtsjahr{0} {}

Person::Person(std::string name, int geburtsjahr) : name{name}, geburtsjahr{geburtsjahr} {}

void Person::print() const
{
    std::cout << this->name << " ist " << this->geburtsjahr << " geboren" << std::endl;
}