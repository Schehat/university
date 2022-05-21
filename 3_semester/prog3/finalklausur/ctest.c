#include <iostream>

using namespace std;

class A
{
public:
    char c;
    A()
    {
        c = '0';
        cout << " AS" << c;
    }
    A(char pc)
    {
        c = pc;
        cout << " A+" << c;
    }
    A(const A &a)
    {
        c = a.c;
        cout << " AC" << c;
    }
    A &operator=(const A &a)
    {
        c = a.c;
        cout << " A =" << c;
        return *this;
    }
};
class B
{
public:
    A a;
    B() { cout << " BS"; }
    B(const B &b) : a{b.a} { cout << " BC"; }
    B &operator=(const B &b)
    {
        a = b.a;
        cout << " B =";
        return *this;
    }
};
void tipp(void)
{
    B b{};
}
void aufgabe()
{
    A i{'i'};
    A k{i};
    A m{'m'};
    B o{};
    o.a = m;
    B p = o;
    o = p;
}
int main(void)
{
    tipp();
    cout << " |";
    aufgabe();
    cout << endl;
}
