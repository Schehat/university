#include "Person.h"
#define SIZE 2

using namespace std;

int main(void)
{
    Person arr[SIZE];
    arr[0] = Person("Schehat", 2000);
    arr[1] = Person("Deti", 1999);

    for (auto &i : arr)
    {
        i.print();
    }
}