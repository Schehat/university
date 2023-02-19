#include "Buch.h"

class Buch
{
public:
    Buch(Person *autor, const string &titel);
    ~Buch();
    string getTitel();

private:
    Person *autor;
    const string titel;
};

Buch::Buch(Person *autor, const string &titel) : {autor{autor}, titel{titel}} {}
Buch::~Buch() {}
const string &Buch::getTitel()
{
    return titel;
}