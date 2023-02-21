#include <iostream>

using namespace std;

class A
{
public:
    int x;
};

A &foo(void)
{
    A a{};
    a.x = 10;
    return a;
}

int main(void)
{
    A a{foo()};
    cout << a.x;
    return 0;
}