#include <iostream>
#include "Person.h"
#include "Buch.h"
#include "Lehrbuch.h"

using namespace std;

int main(void)
{
    string wohnort{"Camebridge"};
    string gebort("Oxford");
    Person p{45, "Hawking", &wohnort, &gebort};

    string titelB{"Eine unglaubliche Reise ins Universum"};
    string titelL{"Physik 1"};
    Buch b{&p, titelB};
    Lehrbuch l(&p, titelL);

    cout << "Buch: " << b.getTitel() << ", Lehrbuch: " << l.getTitel();

    return 0;
}
