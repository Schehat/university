#ifndef ORT_H
#define ORT_H

#include <string>
using std::string;

class Ort
{
public:
    Ort(string name, int leange, int breite);

private:
    int leange;
    int breite;
    string name;
};

#endif