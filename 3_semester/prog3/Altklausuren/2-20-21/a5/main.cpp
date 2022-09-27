#include <iostream>
#include "Person.h"
#include "Baby.h"

using namespace std;

int main(void)
{
    string wohnort{"Hannover"};
    string gebort("WHY");
    Person a{21, "Schehat", &wohnort, &gebort};

    cout << *(a.wohnort) << "\n";

    *(a.wohnort) = "HA";

    Baby b{"Ax", &wohnort, &gebort};
    cout << *(b.wohnort);
}