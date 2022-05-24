#include <string>
#include <iostream>

using namespace std;

class Ort
{
public:
    string *name;
    int laenge;
    int breite;

    Ort &operator=(const Ort &other)
    {
        if (this == &other)
            return *this;
        delete name;
        name = new string{*other.name};
        laenge = other.laenge;
        breite = other.breite;
        return *this;
    }

    bool operator==(const Ort &other)
    {
        return laenge == other.laenge && breite == other.breite && *name == *other.name;
    }

    Ort(string *name, int laenge, int breite) : name{new string{*name}}, laenge{laenge}, breite{breite} {}

    Ort(const Ort &other)
    {
        name = nullptr;
        *this = other;
    }
};

int main(void)
{
    string hannover = "Hannover";
    string hamburg = "Hamburg";
    Ort o1{&hannover, 10, 10};
    Ort o2{&hamburg, 10, 10};

    Ort o3{o1};

    cout << (o1 == o3);
}