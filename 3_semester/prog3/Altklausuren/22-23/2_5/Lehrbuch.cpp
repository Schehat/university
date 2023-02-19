public:
Lehrbuch(Person *autor, const string &titel);
virtual ~Lehrbuch() override;
virtual string getTitel() override;
}
;

#include "Lehrbuch.h"
#include "Buch.h"

Lehrbuch::Lehrbuch(Person *person, const string &titel) : {Buch{person, titel}}
{
}

const string &Lehrbuch::getTitel()
{
    return Buch::getTitel() + " Lehrbuch";
}