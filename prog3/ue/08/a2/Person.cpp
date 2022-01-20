#include <iostream>
#include <string>
#include "Person.h"

Person::Person()
{
    this->name = "";
    this->geburtsjahr = 0;
}

Person::Person(std::string name, int geburtsjahr)
{
    this->name = name;
    this->geburtsjahr = geburtsjahr;
}

void Person::print()
{
    std::cout << this->name << " ist " << this->geburtsjahr << " geboren" << std::endl;
}