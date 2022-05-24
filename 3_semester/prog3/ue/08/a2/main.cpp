#include "Person.h"
#include <iostream>
#define SIZE 2

using namespace std;

int main(void)
{
    Person arr[SIZE]{Person("Schehat", 2000), Person("Deti", 1999)};

    for (const auto &i : arr)
    {
        i.print();
    }

    Person non{};
    non.print();
}